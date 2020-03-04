package com.demmage.habr.entities;

public class Article {

    private String habrId;

    private String title;
    private String tags;
    private String body;
    private String author;

    private String date;
    private String cachedDate;

    private Article() {
    }

    public Article(String habrId, String title, String tags, String body, String author, String date, String cachedDate) {
        this.habrId = habrId;
        this.title = title;
        this.tags = tags;
        this.body = body;
        this.author = author;
        this.date = date;
        this.cachedDate = cachedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getTags() {
        return tags;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getCachedDate() {
        return cachedDate;
    }

    public String getHabrId() {
        return habrId;
    }

    public void setHabrId(String habrId) {
        this.habrId = habrId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "habrId='" + habrId + '\'' +
                ", title='" + title + '\'' +
                ", tags='" + tags + '\'' +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", cachedDate='" + cachedDate + '\'' +
                '}';
    }

    public static class Builder {

        private Article article = new Article();

        public Builder setTitle(String title) {
            article.title = title;
            return this;
        }

        public Builder setTags(String tags) {
            article.tags = tags;
            return this;
        }

        public Builder setAuthor(String author) {
            article.author = author;
            return this;
        }

        public Builder setDate(String date) {
            article.date = date;
            return this;
        }

        public Builder setCachedDate(String cachedDate) {
            article.cachedDate = cachedDate;
            return this;
        }

        public Builder setHabrId(String habrId) {
            article.habrId = habrId;
            return this;
        }

        public Article build() {
            return article;
        }
    }
}
