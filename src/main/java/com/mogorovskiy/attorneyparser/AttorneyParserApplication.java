package com.mogorovskiy.attorneyparser;

import com.mogorovskiy.attorneyparser.model.Attorney;
import com.mogorovskiy.attorneyparser.parser.AttorneyParser;
import com.mogorovskiy.attorneyparser.parser.golaw.GolawAttorneyParser;
import com.mogorovskiy.attorneyparser.parser.uristyua.*;

import java.io.IOException;
import java.util.*;

public class AttorneyParserApplication {

    private static final AttorneyParser[] parsers = new AttorneyParser[] {
            new GolawAttorneyParser(),
            new UristyAttorneyParser()
    };

    public static void main(String[] args) throws IOException {
        new AttorneyParserApplication().run();
    }

    public void run() throws IOException {
        for (AttorneyParser parser : parsers) {
            List<Attorney> attorneys = parser.parse();

            attorneys.forEach(System.out::println);
            System.out.println();
        }
    }
}
