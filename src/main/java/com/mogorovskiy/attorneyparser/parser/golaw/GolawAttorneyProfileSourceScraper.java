package com.mogorovskiy.attorneyparser.parser.golaw;

import com.mogorovskiy.attorneyparser.model.*;
import com.mogorovskiy.attorneyparser.parser.AttorneyProfileSourceScraper;
import org.jsoup.*;

import java.io.*;


public class GolawAttorneyProfileSourceScraper implements AttorneyProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String profileUrl) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();
        attorneyProfileSource.setSource(Jsoup.connect(profileUrl).get().toString());
        attorneyProfileSource.setProfileUrl(profileUrl);
        return attorneyProfileSource;
    }
}
