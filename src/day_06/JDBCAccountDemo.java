package day_06;

import java.sql.*;

/**
 * @author Maizi
 * @PackageName:day_06
 * @ClassName: JDBCAccountDEMO
 * @Description:
 * @Date 2020/7/30 13:24
 */
public class JDBCAccountDemo {
    //注册驱动
    //获取连接

    //获取sql执行对象
    //执行sql对象
    //释放资源
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?useUnicode=true&characterEncoding=UTF-8", "root", "root");
             statement = connection.createStatement();

             connection.setAutoCommit(false);//设置自动提交事务,就是开启事务

            int rows = statement.executeUpdate("update account set money=money-1000 where name ='jack'");
            System.out.println(1/0);
            int rows2 = statement.executeUpdate("update account set money=money+1000 where name ='test'");

            if (rows > 0 && rows2 > 0) {
                System.out.println("转账成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账出现问题,回滚事务");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}
