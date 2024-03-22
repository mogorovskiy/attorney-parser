package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.Attorney;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AttorneyParser {

    private final AttorneyProfileUrlsScraper profileUrlsScraper;
    private final AttorneyProfileSourceScraper sourceScraper;
    private final AttorneyProfileParser profileParser;

    public final List<Attorney> parse() {
        List<String> profileUrls = profileUrlsScraper.scrape();

        List<String> profileSources = profileUrls.stream()
                .map(sourceScraper::scrape)
                .toList();

        return profileSources.stream()
                .map(profileParser::parse)
                .toList();
    }
}
