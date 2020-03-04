package com.demmage.habr.net;

import java.io.IOException;

public class PageDownloader extends Downloader {

    private static final String BASE_URL = "https://habr.com/ru/post/";

    public String download(int postNumber) throws IOException {
        return super.download(BASE_URL + postNumber);
    }
}
