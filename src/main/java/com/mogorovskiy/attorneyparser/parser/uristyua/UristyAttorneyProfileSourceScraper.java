package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.model.AttorneyProfileSource;
import com.mogorovskiy.attorneyparser.parser.AttorneyProfileSourceScraper;
import org.jsoup.Jsoup;
import java.io.IOException;

public class UristyAttorneyProfileSourceScraper implements AttorneyProfileSourceScraper {

    @Override
    public AttorneyProfileSource scrape(String profileUrl) throws IOException {
        AttorneyProfileSource attorneyProfileSource = new AttorneyProfileSource();
        attorneyProfileSource.setSource(Jsoup.connect(profileUrl).get().toString());
        attorneyProfileSource.setProfileUrl(profileUrl);
        return attorneyProfileSource;
    }
}
