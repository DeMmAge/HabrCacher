package com.demmage.habr.parser;

import com.demmage.habr.net.PageDownloader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ButtonsParserTest {

    @Test
    void getUrls() {
        PageDownloader downloader = new PageDownloader();
        String page = downloader.download(1);
        ButtonsParser parser = new ButtonsParser();

        System.out.println(parser.getUrls(page));


    }
}