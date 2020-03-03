package com.demmage.habr.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PageDownloader {

    private static final String BASE_URL = "https://habr.com/ru/all/page";

    public String download(int pageNumber) {
        try {
            URL url = new URL(BASE_URL + pageNumber);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            Scanner reader = new Scanner(inputStream);
            StringBuilder result = new StringBuilder();
            while (reader.hasNext()) {
                result.append(reader.nextLine());
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
