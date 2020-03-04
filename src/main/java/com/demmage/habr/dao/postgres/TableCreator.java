package com.demmage.habr.dao.postgres;

import com.demmage.habr.dao.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableCreator {

    private DaoFactory daoFactory = new DaoFactory();

    private static final String SQL_DB_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS articles (id serial primary key, habr_id varchar(7)," +
            "title varchar(100), author varchar(50), tags varchar(300), body text, date varchar(25), cached_date varchar(30));";

    public void createTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(SQL_DB_CREATE_QUERY);
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