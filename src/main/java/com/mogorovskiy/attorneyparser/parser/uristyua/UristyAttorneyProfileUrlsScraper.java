package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.parser.*;
import org.jsoup.*;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class UristyAttorneyProfileUrlsScraper implements AttorneyProfileUrlsScraper {
    private static final String LISTING_URL = "https://uristy.ua/lawyers/cernigiv";
    private static final String PROFILE_URLS_SELECTOR = "p[class=lead] a";

    @Override
    public List<String> scrape() throws IOException {
        List<String> allAttorneysUrls = Jsoup.connect(LISTING_URL).get()
                .select(PROFILE_URLS_SELECTOR).stream()
                .map(element -> element.absUrl("href"))
                .toList();
        return filterAttorneysWithPhoto(allAttorneysUrls);
    }

    private List<String> filterAttorneysWithPhoto(List<String> allAttorneys) {
        List<String> attorneysWithPhoto = new ArrayList<>();
        for (String attorney: allAttorneys) {
            String id = extractLastDigits(attorney);
            assert id != null;
            if (id.length() > 4) {
                attorneysWithPhoto.add(attorney);
            }
        }
        return attorneysWithPhoto;
    }

    public static String extractLastDigits(String url) {
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }
}
