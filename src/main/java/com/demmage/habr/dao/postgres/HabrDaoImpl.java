package com.demmage.habr.dao.postgres;

import com.demmage.habr.dao.DaoFactory;
import com.demmage.habr.entities.Article;

public class HabrDaoImpl implements HabrDao {

    private DaoFactory daoFactory = new DaoFactory();

    @Override
    public void cacheArticle(Article article) {

    }
}
