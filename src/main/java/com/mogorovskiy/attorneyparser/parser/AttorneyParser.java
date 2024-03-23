package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.*;
import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.*;

@RequiredArgsConstructor
public abstract class AttorneyParser {

    private final AttorneyProfileUrlsScraper profileUrlsScraper;
    private final AttorneyProfileSourceScraper sourceScraper;
    private final AttorneyProfileParser profileParser;

    public final List<Attorney> parse() throws IOException {
        List<String> profileUrls = profileUrlsScraper.scrape();

        List<AttorneyProfileSource> profileSources = new ArrayList<>();
        for (String profileUrl : profileUrls) {
            profileSources.add(sourceScraper.scrape(profileUrl));
        }

        List<Attorney> attorneys = new ArrayList<>();
        for (AttorneyProfileSource source : profileSources) {
            attorneys.add(profileParser.parse(source));
        }
        return attorneys;
    }
}
