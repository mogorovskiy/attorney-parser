package com.mogorovskiy.attorneyparser.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttorneyProfileSource {
    private String source;
    private String profileUrl;
}
