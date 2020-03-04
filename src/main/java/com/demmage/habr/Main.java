package com.demmage.habr;

import com.demmage.habr.dao.postgres.HabrDao;
import com.demmage.habr.dao.postgres.HabrDaoImpl;
import com.demmage.habr.dao.postgres.TableCreator;
import com.demmage.habr.entities.Article;
import com.demmage.habr.net.PageDownloader;
import com.demmage.habr.parser.ArticleParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        new TableCreator().createTable();

        HabrDao dao = new HabrDaoImpl();
        PageDownloader downloader = new PageDownloader();
        ArticleParser parser = new ArticleParser();

        for (int i = 1; i <= 1000; i++) {
            try {
                String page = downloader.download(i);
                Article article = parser.parse(page, i);
                dao.cacheArticle(article);
                System.out.println("Cached post " + i);
            } catch (IOException e) {
                System.out.println("Forbidden " + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
