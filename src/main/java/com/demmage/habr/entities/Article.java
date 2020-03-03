package com.demmage.habr.entities;

import java.util.Date;

public class Article {

    private String title;
    private String[] tags;
    private String body;
    private String author;

    private Date date;
    private Date cachedDate;

    public Article() {
    }

    public static class Builder {

        private Article article = new Article();

        public Builder setTitle(String title) {
            article.title = title;
            return this;
        }

        public Builder setTags(String[] tags) {
            article.tags = tags;
            return this;
        }

        public Builder setAuthor(String author) {
            article.author = author;
            return this;
        }

        public Builder setDate(Date date) {
            article.date = date;
            return this;
        }

        public Builder setCachedDate(Date cachedDate) {
            article.cachedDate = cachedDate;
            return this;
        }

        public Article build() {
            return article;
        }
    }
}
