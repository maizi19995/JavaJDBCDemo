package day_02;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Maizi
 * @PackageName:day_02
 * @ClassName: JDBCUtils
 * @Description:
 * @Date 2020/7/28 5:51
 */
public class JDBCUtils {
    /**
     * 这个工具类,获取一个数据库连接
     */
    private static String driverName="com.mysql.jdbc.Driver";
    private  static String url="jdbc:mysql://localHost:3306/day04?useUnicode=true&characterEncoding=UTF-8";
    private static String username="root";
    private static String password="root";
    private static ArrayList<Connection>conns=new ArrayList<>();
    static{
        try {
            Class.forName(driverName);
            for (int i = 0; i < 10; i++) {
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection(url,username,password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conns.add(connection);
            }
        } catch (ClassNotFoundException e) {
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
        Connection connection=conns.remove(0);
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
