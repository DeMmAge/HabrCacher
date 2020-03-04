package com.demmage.habr.dao;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

class DaoFactoryTest {

    @Test
    public void shouldReturnConnectionWhenDatabaseExists() throws SQLException {
        DaoFactory daoFactory = new DaoFactory();
        Connection connection = daoFactory.getConnection();
        if (!connection.isValid(3)) {
            fail();
        }
    }
}