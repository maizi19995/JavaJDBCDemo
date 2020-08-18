package com.itheima.utils;

/**
 * @author Maizi
 * @PackageName:com.itheima.utils
 * @ClassName: ConnectionManager
 * @Description:
 * @Date 2020/8/9 14:09
 */

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接管理类
 *  主要负责获取连接,开启事务,提交事务,回滚事务
 *
 */
public class ConnectionManager {
        //定义一个集合
    private static ThreadLocal<Connection>threadLocal=new ThreadLocal<>();
    //获取连接
    public static Connection getConnection(){
        //从threadlocal1中获取连接
        Connection connection= threadLocal.get();
        //判断connection是否为空
        if(connection==null){
            try {
                //说明service层是第一次获取
                connection=C3P0Utils02.getConnection();
                threadLocal.set(connection);
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        //如果不为空,说明dao层是第二次以后获取
        return connection;
    }
    //开启事务
    public static void start(){
        try {
            ConnectionManager.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        try {
            ConnectionManager.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚事务
    public static void rollback(){
        try {
            ConnectionManager.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        try {
            ConnectionManager.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
