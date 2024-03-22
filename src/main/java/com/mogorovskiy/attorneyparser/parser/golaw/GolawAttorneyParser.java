package com.mogorovskiy.attorneyparser.parser.golaw;

import com.mogorovskiy.attorneyparser.parser.AttorneyParser;

public class GolawAttorneyParser extends AttorneyParser {
    public GolawAttorneyParser() {
        super(
                new GolawAttorneyProfileUrlsScraper(),
                new GolawAttorneyProfileSourceScraper(),
                new GolawAttorneyProfileParser()
        );
    }
}
