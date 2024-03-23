package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.Attorney;
import com.mogorovskiy.attorneyparser.model.AttorneyProfileSource;

public interface AttorneyProfileParser {
    Attorney parse(AttorneyProfileSource source);
}
