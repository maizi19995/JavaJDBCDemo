package JDBCTest;

import java.sql.*;

/**
 * @author Maizi
 * @PackageName:JDBCTest
 * @ClassName: TestDemo3
 * @Description:
 * @Date 2020/7/25 22:44
 */
public class TestDemo3 {
    public static String driverName="com.mysql.jdbc.Driver";
    private  static String url="jdbc:mysql://localHost:3306/day04?useUnicode=true&characterEncoding=UTF-8";
    private static String username="root";
    private static String password="root";
    private static  Statement statement=null;
    private static Connection connection=null;
    private static ResultSet resultSet=null;
    public static void main(String[] args) {
        try {
            getconnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getconnection() throws Exception{
        //1注册驱动
            Class.forName(driverName);
        //2.获取连接
            Connection connection = DriverManager.getConnection(url,username,password);
        //3获取sql语句执行对象
            Statement statement=connection.createStatement();
        //4使用执行对象执行sql语句,获取结果集
            ResultSet resultSet=statement.executeQuery("select * from category");
        //5处理结果集
        while(resultSet.next()){
            try {
                Object cid = resultSet.getObject("cid");
                Object cname=resultSet.getObject("cname");
                System.out.println(cid+"\t"+cname);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

            resultSet.close();
            connection.close();
            statement.close();


    }
}
