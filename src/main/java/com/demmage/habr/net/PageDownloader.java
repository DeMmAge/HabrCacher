package com.demmage.habr.net;

public class PageDownloader extends Downloader {

    private static final String BASE_URL = "https://habr.com/ru/all/page";

    public String download(int pageNumber) {
        return super.download(BASE_URL + pageNumber);
    }
}
