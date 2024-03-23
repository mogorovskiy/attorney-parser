package com.mogorovskiy.attorneyparser.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class Attorney {
    private String fullName;
    private String title;
    private String bio;
    private String linkedinUrl;
    private String photoUrl;
    private String profileUrl;
    private List<String> locations;
    private List<String> emails;
    private List<String> phones;
    private List<String> practiceAreas;
    private List<String> specialties;
}
