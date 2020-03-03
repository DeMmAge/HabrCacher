package com.demmage.habr.dao.postgres;

import com.demmage.habr.entities.Article;

public interface HabrDao {

    void cacheArticle(Article article);

}
