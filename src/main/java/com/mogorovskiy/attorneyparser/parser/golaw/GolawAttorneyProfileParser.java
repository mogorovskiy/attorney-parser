package com.mogorovskiy.attorneyparser.parser.golaw;

import com.mogorovskiy.attorneyparser.model.*;
import com.mogorovskiy.attorneyparser.parser.AttorneyProfileParser;
import org.jsoup.*;
import org.jsoup.nodes.*;

import static com.mogorovskiy.attorneyparser.helper.JsoupHelper.toStringList;

public class GolawAttorneyProfileParser implements AttorneyProfileParser {

    public static final String TITLE_SELECTOR = "p[class=lawyer-ab__position]";
    public static final String BIO_SELECTOR = "div[class=lawyer-ab__text-content]";
    public static final String PHOTO_URL_SELECTOR = "img[class=attachment-people size-people wp-post-image]";
    public static final String SPECIALTIES_SELECTOR = "h2:contains(sector) + .scroll-cont li";
    private static final String FULL_NAME_SELECTOR = "h1[class=header-page__title]";
    private static final String LINKEDIN_SELECTOR = "a.layers__linked";
    public static final String LOCATION_SELECTOR = "li[class=lawyer-ab__item-cont]";
    public static final String EMAILS_SELECTOR = "a[href^=mailto]";
    public static final String PHONES_SELECTOR = "a[href^=tel]";
    public static final String PRACTICE_AREAS_SELECTOR = "h2:contains(practice) + .scroll-cont li";

    @Override
    public Attorney parse(AttorneyProfileSource source) {
        Document attorneyPage = Jsoup.parse(source.getSource());
        Attorney attorney = new Attorney();
        attorney.setFullName(attorneyPage.selectFirst(FULL_NAME_SELECTOR).text());
        attorney.setTitle(attorneyPage.selectFirst(TITLE_SELECTOR).text());
        attorney.setBio(attorneyPage.selectFirst(BIO_SELECTOR).text());
        attorney.setLinkedinUrl(attorneyPage.selectFirst(LINKEDIN_SELECTOR).attr("href"));
        attorney.setPhotoUrl(attorneyPage.selectFirst(PHOTO_URL_SELECTOR).attr("data-src"));
        attorney.setProfileUrl(source.getProfileUrl());
        attorney.setLocations(toStringList(attorneyPage.select(LOCATION_SELECTOR)));
        attorney.setEmails(toStringList(attorneyPage.select(EMAILS_SELECTOR)));
        attorney.setPhones(toStringList(attorneyPage.select(PHONES_SELECTOR)));
        attorney.setPracticeAreas(toStringList(attorneyPage.select(PRACTICE_AREAS_SELECTOR)));
        attorney.setSpecialties(toStringList(attorneyPage.select(SPECIALTIES_SELECTOR)));
        return attorney;
    }
}
