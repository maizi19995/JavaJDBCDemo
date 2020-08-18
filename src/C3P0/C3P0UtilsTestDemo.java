package C3P0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maizi
 * @PackageName:C3P0
 * @ClassName: C3P0UtilsTestDemo
 * @Description:
 * @Date 2020/7/28 16:51
 */
public class C3P0UtilsTestDemo {
    public static void main(String[] args) throws SQLException {
        //insert();
       // update();
        query();
    }
    public static void insert() throws SQLException {
        //获取连接
        Connection connection=C3P0Utils02.getConnection();
        //获取执行对象
        Statement statement = connection.createStatement();
        //执行sql
        int rows=statement.executeUpdate("insert into userss (username,password)values ('didi','134')");
        System.out.println(rows);
        C3P0Utils02.closeAll(connection,statement,null);

    }
    public static void update() throws SQLException {
        //获取连接
        Connection connection=C3P0Utils02.getConnection();
        //获取执行对象
        Statement statement = connection.createStatement();
        //执行sql
        int rows=statement.executeUpdate("update userss set `password`='1567' where id=5" );
        System.out.println(rows);
        C3P0Utils02.closeAll(connection,statement,null);
    }
    public static void query() throws SQLException {
        Connection connection=C3P0Utils02.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from userss";
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getObject("username")+"\t"+resultSet.getObject("password"));
        }
        C3P0Utils02.closeAll(connection,statement,resultSet);
    }
    public static void delete() throws SQLException {
        //获取连接
        Connection connection=C3P0Utils02.getConnection();
        //获取执行对象
        Statement statement = connection.createStatement();
        //执行sql
        int rows=statement.executeUpdate("delete from userss WHERE id=5" );
        System.out.println(rows);
        C3P0Utils02.closeAll(connection,statement,null);
    }
}
