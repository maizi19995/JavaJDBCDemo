package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Maizi
 * @PackageName:JDBCTest
 * @ClassName: JDBCDemo1
 * @Description:
 * @Date 2020/7/24 19:56
 * DriverManager 驱动管理类  加载各种驱动
 * Connection   代表数据库链接接口,实现类在驱动中
 * Statement    执行SQL语句的接口,实现类在驱动中
 * ResultSet    结果集接口,实现类在驱动中
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //使用DriverManager注册
        Class.forName("com.mysql.jdbc.Driver");
        //获取和数据库的连接对象,是Connection接口的实现类对象
        String url="jdbc:mysql://localhost:3306/day04";
        //jdbc 数据库厂商名 IP地址 端口号 要连接的数据库
        Connection connection = DriverManager.getConnection(url,"root","root");
        Statement statement = connection.createStatement();
        ResultSet rs=statement.executeQuery("select*from category");
        while(rs.next()){
              Object cid=rs.getObject("cid");
              Object cname=rs.getObject("cname");
            System.out.println(cid+"\t" +cname);
        }
        rs.close();
        statement.close();
        connection.close();
    }
}
