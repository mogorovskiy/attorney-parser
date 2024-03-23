package com.mogorovskiy.attorneyparser.parser.golaw;

import com.mogorovskiy.attorneyparser.parser.AttorneyProfileUrlsScraper;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.List;

public class GolawAttorneyProfileUrlsScraper implements AttorneyProfileUrlsScraper {

    private static final String LISTING_URL = "https://golaw.ua/people/";
    private static final String PROFILE_URLS_SELECTOR = "h2 > a";

    @Override
    public List<String> scrape() throws IOException {
        return Jsoup.connect(LISTING_URL).get()
                .select(PROFILE_URLS_SELECTOR).stream()
                .map(element -> element.attr("href"))
                .toList();
    }
}
