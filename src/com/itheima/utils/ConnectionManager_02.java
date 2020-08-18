package com.itheima.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager_02 {

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();


    public static Connection getConnection() throws SQLException {

        Connection conn = tl.get();

        if (conn == null) {

            conn = C3P0Utils02_03.getConnection();
            tl.set(conn);
        }

        return conn;
    }


    public static void start() throws SQLException {
        ConnectionManager.getConnection().setAutoCommit(false);
    }


    public static void commit() throws SQLException {
        ConnectionManager.getConnection().commit();
    }

    public static void rollback() throws SQLException {
        ConnectionManager.getConnection().rollback();
    }

    public static void close() throws SQLException {
        ConnectionManager.getConnection().close();
    }
}
