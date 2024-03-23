package com.mogorovskiy.attorneyparser.helper;

import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.util.*;

public class JsoupHelper {

    public static List<String> toStringList(Elements elements) {
        List<String> result = new ArrayList<>();
        for (Element element : elements) {
            result.add(element.text());
        }
        return result;
    }
}
