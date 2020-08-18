package com.itheima.utils;

/**
 * @author Maizi
 * @PackageName:C3P0
 * @ClassName: C3P0Utils
 * @Description:
 * @Date 2020/7/28 16:26
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 给用户提供连接
 */
public class   C3P0Utils02 {
    //连接池
    private static ComboPooledDataSource ds=new ComboPooledDataSource("abcd");
    //配置文件设置连接
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        //获取连接
        return ds.getConnection();
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
