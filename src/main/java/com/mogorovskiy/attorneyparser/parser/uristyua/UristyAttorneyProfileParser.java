package com.mogorovskiy.attorneyparser.parser.uristyua;

import com.mogorovskiy.attorneyparser.model.*;
import com.mogorovskiy.attorneyparser.parser.*;
import org.jsoup.*;
import org.jsoup.nodes.*;

import static com.mogorovskiy.attorneyparser.helper.JsoupHelper.toStringList;

public class UristyAttorneyProfileParser implements AttorneyProfileParser {
    private static final String FULL_NAME_SELECTOR = "h1";
    public static final String TITLE_SELECTOR = "h2:contains(О себе) ~ *:first-of-type";
    public static final String BIO_SELECTOR = "span[class=badge]";
    public static final String PHOTO_URL_SELECTOR = "img[class=img-responsive lawyer-view-img pull-left]";
    public static final String SPECIALTIES_SELECTOR = "ul[class=specialization-list p-0]";

    @Override
    public Attorney parse(AttorneyProfileSource source) {
        Document attorneyPage = Jsoup.parse(source.getSource());
        Attorney attorney = new Attorney();
        attorney.setFullName(attorneyPage.selectFirst(FULL_NAME_SELECTOR).text());
        attorney.setTitle(attorneyPage.select(TITLE_SELECTOR).text());
        attorney.setBio(attorneyPage.select(BIO_SELECTOR).text());
        attorney.setPhotoUrl(attorneyPage.selectFirst(PHOTO_URL_SELECTOR).attr("src"));
        attorney.setProfileUrl(source.getProfileUrl());
        attorney.setSpecialties(toStringList(attorneyPage.select(SPECIALTIES_SELECTOR)));
        return attorney;
    }
}
