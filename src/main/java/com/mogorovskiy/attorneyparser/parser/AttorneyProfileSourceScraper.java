package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.*;

import java.io.*;

public interface AttorneyProfileSourceScraper {
    AttorneyProfileSource scrape(String profileUrl) throws IOException;
}
