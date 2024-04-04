package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.parser.AttorneyProfileUrlsScraper;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UristyAttorneyProfileUrlsScraper implements AttorneyProfileUrlsScraper {
    private static final String LISTING_URL = "https://uristy.ua/lawyers/cernigiv";
    private static final String PROFILE_URLS_SELECTOR = "p[class=lead] a";
    private static final int MINIMAL_NUMBER_OF_ID_CHARACTERS = 4;

    @Override
    public List<String> scrape() throws IOException {
        return Jsoup.connect(LISTING_URL).get()
                .select(PROFILE_URLS_SELECTOR).stream()
                .map(element -> element.absUrl("href"))
                .filter(attorneyUrl -> {
                    String id = extractLastDigits(attorneyUrl);
                    return id != null && id.length() > MINIMAL_NUMBER_OF_ID_CHARACTERS;
                })
                .toList();
    }

    private String extractLastDigits(String url) {
        Pattern pattern = Pattern.compile("\\d+$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }
}
