package com.demmage.habr;

import com.demmage.habr.dao.postgres.HabrDao;
import com.demmage.habr.dao.postgres.HabrDaoImpl;
import com.demmage.habr.dao.postgres.TableCreator;
import com.demmage.habr.entities.Article;
import com.demmage.habr.net.PageDownloader;
import com.demmage.habr.parser.ArticleParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class HabrCacher {

    private HabrDao dao = new HabrDaoImpl();
    private PageDownloader downloader = new PageDownloader();
    private ArticleParser parser = new ArticleParser();

    private final OkHttpClient httpClient = new OkHttpClient();
    private String cachedPage = null; // TODO

    public HabrCacher() {
        new TableCreator().createTable();
    }

    private int getPostCode(int post) {
        Request request = new Request.Builder()
                .url(PageDownloader.BASE_URL + post)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            cachedPage = Objects.requireNonNull(response.body()).string();
            return response.code();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean checkPost(int post) {
        return getPostCode(post) == 200;
    }

    public boolean cache(int post) {
        if (checkPost(post)) {
            try {
                Article article = parser.parse(downloader.download(post), post); // TODO: Cached page
                dao.cacheArticle(article);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }
}
