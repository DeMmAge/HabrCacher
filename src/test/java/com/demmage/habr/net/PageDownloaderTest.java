package com.demmage.habr.net;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PageDownloaderTest {

    @Test
    void shouldDownloadContentWhenPageNumberGiven() throws IOException {
        PageDownloader downloader = new PageDownloader();
        String output = downloader.download(1);
        assertNotNull(output);
    }
}