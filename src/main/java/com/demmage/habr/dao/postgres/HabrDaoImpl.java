package com.demmage.habr.dao.postgres;

import com.demmage.habr.dao.DaoFactory;
import com.demmage.habr.entities.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HabrDaoImpl implements HabrDao {

    private DaoFactory daoFactory = new DaoFactory();

    public HabrDaoImpl() {

    }

    @Override
    public void cacheArticle(Article article) {
        String sqlQuery = "INSERT INTO articles (habr_id, title, author, tags, body, date, cached_date) VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, article.getHabrId());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getAuthor());
            statement.setString(4, article.getTags());
            statement.setString(5, article.getBody());
            statement.setString(6, article.getDate());
            statement.setString(7, article.getCachedDate());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
