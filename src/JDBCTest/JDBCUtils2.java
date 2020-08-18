package JDBCTest;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Maizi
 * @PackageName:JDBCTest
 * @ClassName: JDBCUtils
 * @Description:
 * @Date 2020/7/24 23:24
 */
public class JDBCUtils2 {
    /**
     * 这个工具类,获取一个数据库连接
     */
    private static String driverName=null;
    private  static String url=null;
    private static String username=null;
    private static String password=null;
    static{

        try {
            Properties ps=new Properties();
            ps.load(new FileInputStream("gjdbc_config.properties"));
            driverName=ps.getProperty("driverName");
            url=ps.getProperty("url");
            username=ps.getProperty("username");
            password=ps.getProperty("password");

            Class.forName(driverName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
            throw new RuntimeException();
        }
    }
    public static Connection getConnection () throws ClassNotFoundException, SQLException {
//        //优化,通过静态代码块使驱动只加载一次
//        //加载驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //获取和数据库的连接
        Connection connection= DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static void closeALL(Connection connection, Statement statement, ResultSet resultSet )  {
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
