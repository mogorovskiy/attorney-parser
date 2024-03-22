package com.mogorovskiy.attorneyparser;

import com.mogorovskiy.attorneyparser.model.Attorney;
import com.mogorovskiy.attorneyparser.parser.AttorneyParser;
import com.mogorovskiy.attorneyparser.parser.golaw.GolawAttorneyParser;

import java.util.List;

public class AttorneyParserApplication {

    private static final AttorneyParser[] parsers = new AttorneyParser[] {
            new GolawAttorneyParser()
    };

    public static void main(String[] args) {
        new AttorneyParserApplication().run();
    }

    public void run() {
        for (AttorneyParser parser : parsers) {
            List<Attorney> attorneys = parser.parse();

            attorneys.forEach(System.out::println);
            System.out.println();
        }
    }
}
