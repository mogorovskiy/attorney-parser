package com.mogorovskiy.attorneyparser.parser;

import java.io.IOException;
import java.util.List;

public interface AttorneyProfileUrlsScraper {
    List<String> scrape() throws IOException;
}
