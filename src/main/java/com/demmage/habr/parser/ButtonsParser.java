package com.demmage.habr.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ButtonsParser {

    private static final String START = "<ul class=\"content-list content-list_posts shortcuts_items\">";
    private static final String END = "</ul>";

    public String[] getUrls(String page) {
        Pattern pattern = Pattern.compile(START + ".*?" + END);
        Matcher matcher = pattern.matcher(page);
        String splitContent = "";
        while (matcher.find()) {
            splitContent = matcher.group();
        }
        System.out.println(splitContent);
        return null;
    }

}
