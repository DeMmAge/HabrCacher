package com.demmage.habr;

import com.demmage.habr.dao.postgres.HabrDao;
import com.demmage.habr.dao.postgres.HabrDaoImpl;
import com.demmage.habr.dao.postgres.TableCreator;
import com.demmage.habr.entities.Article;
import com.demmage.habr.net.PageDownloader;
import com.demmage.habr.parser.ArticleParser;

import java.io.IOException;

public class HabrCacher {

    private HabrDao dao = new HabrDaoImpl();
    private PageDownloader downloader = new PageDownloader();
    private ArticleParser parser = new ArticleParser();

    public HabrCacher() {
        new TableCreator().createTable();
    }

    public boolean cache(int post) {
        try {
            String page = downloader.download(post);
            Article article = parser.parse(page, post);
            dao.cacheArticle(article);
            System.out.println("Cached post " + post);
        } catch (IOException e) {
            System.out.println("Forbidden " + post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
