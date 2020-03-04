package com.demmage.habr.parser;

import com.demmage.habr.entities.Article;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleParser {

    private static final String START = "<div class=\"post__wrapper\">";
    private static final String END = "<div class=\"overlay hidden\" id=\"js-vote-reason\">";
    private static final String UNDEF = "Undef";
    private static final String ALL = "(.*?)";

    public Article parse(String page) {
        Pattern pattern = Pattern.compile(START + ALL + END);
        Matcher matcher = pattern.matcher(page);
        String splitContent = "";
        if (matcher.find()) {
            splitContent = matcher.group(1);
        }
        Article.Builder builder = new Article.Builder();
        builder.setCachedDate(Calendar.getInstance().getTime().toString());

        Pattern patternAuthor = Pattern.compile("<span class=\"user-info__nickname user-info__nickname_small\">"
                + ALL + "</span>");
        Matcher matcherAuthor = patternAuthor.matcher(splitContent);
        builder.setAuthor(matcherAuthor.find() ? matcherAuthor.group(1) : UNDEF);

        Pattern patternDate = Pattern.compile("<span class=\"post__time\" data-time_published=\""
                + ALL + "\">");
        Matcher matcherDate = patternDate.matcher(splitContent);
        builder.setDate(matcherDate.find() ? matcherDate.group(1) : UNDEF);

        Pattern patternTitle = Pattern.compile("<span class=\"post__title-text\">"
                + ALL + "</span>");
        Matcher matcherTitle = patternTitle.matcher(splitContent);
        builder.setTitle(matcherTitle.find() ? matcherTitle.group(1) : UNDEF);

        return builder.build();
    }
}
