package com.mogorovskiy.attorneyparser.parser;

import com.mogorovskiy.attorneyparser.model.*;

public interface AttorneyProfileParser {
    Attorney parse(AttorneyProfileSource source);
}
