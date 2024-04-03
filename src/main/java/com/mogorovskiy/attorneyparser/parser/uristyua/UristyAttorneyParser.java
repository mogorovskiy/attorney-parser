package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.parser.*;

public class UristyAttorneyParser extends AttorneyParser {
    public UristyAttorneyParser() {
        super(
                new UristyAttorneyProfileUrlsScraper(),
                new UristyAttorneyProfileSourceScraper(),
                new UristyAttorneyProfileParser()
        );
    }
}
