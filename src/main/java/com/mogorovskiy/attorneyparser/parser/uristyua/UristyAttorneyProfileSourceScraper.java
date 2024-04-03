package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.model.*;
import com.mogorovskiy.attorneyparser.parser.*;
import org.jsoup.*;

import java.io.*;

public class UristyAttorneyProfileSourceScraper implements AttorneyProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String profileUrl) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();
        attorneyProfileSource.setSource(Jsoup.connect(profileUrl).get().toString());
        attorneyProfileSource.setProfileUrl(profileUrl);
        return attorneyProfileSource;
    }
}
