package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.AttorneyProfileSource;
import java.io.IOException;

public interface AttorneyProfileSourceScraper {
    AttorneyProfileSource scrape(String profileUrl) throws IOException;
}
