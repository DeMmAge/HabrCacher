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

    public Article parse(String page, int id) {
        Pattern pattern = Pattern.compile(START + ALL + END);
        Matcher matcher = pattern.matcher(page);
        String splitContent = "";
        if (matcher.find()) {
            splitContent = matcher.group(1);
        }
        Article.Builder builder = new Article.Builder();
        builder.setCachedDate(Calendar.getInstance().getTime().toString());
        builder.setHabrId(String.valueOf(id));

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

        Pattern patternBody = Pattern.compile("div class=\"post__text post__text-html post__text_v1\" id=\"post-content-body\" data-io-article-url=\"https://habr.com/ru/post/" + id + "/\">"
                + ALL + "</div>");
        Matcher matcherBody = patternBody.matcher(splitContent);
        String body = matcherBody.find() ? matcherBody.group(1) : UNDEF;
        body = parseString(body);
        builder.setBody(body);

        Pattern patternTags = Pattern.compile("class=\"inline-list__item-link post__tag  \">"
                + ALL + "</a></li>");
        Matcher matcherTags = patternTags.matcher(splitContent);
        StringBuilder tags = new StringBuilder();
        while (matcherTags.find()) {
            tags.append(matcherTags.group(1)).append(", ");
        }
        if (tags.length() > 2) {
            tags.delete(tags.length() - 2, tags.length());
        }
        builder.setTags(tags.toString());

        return builder.build();
    }

    private String parseString(String s) {
        String res;
        res = s.replace("<br/>", "\n");
        return res;
    }
}
