package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.Attorney;

public interface AttorneyProfileParser {
    Attorney parse(String source);
}
