package com.demmage.habr;

import com.demmage.habr.dao.postgres.HabrDao;
import com.demmage.habr.dao.postgres.HabrDaoImpl;
import com.demmage.habr.net.PageDownloader;
import com.demmage.habr.parser.ArticleParser;

public class Main {

    public static void main(String[] args) {
        HabrDao dao = new HabrDaoImpl();
        PageDownloader downloader = new PageDownloader();
        ArticleParser parser = new ArticleParser();

    }
}
