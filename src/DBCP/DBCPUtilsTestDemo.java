package DBCP;

import java.io.IOException;
import java.sql.*;

/**
 * @author Maizi
 * @PackageName:DBCP
 * @ClassName: DBCPUtilsTestDemo
 * @Description:
 * @Date 2020/7/28 7:04
 */
public class DBCPUtilsTestDemo {
    public static void main(String[] args) throws Exception {
       // update();

        query();
        //insert();
    }

    public static void update() throws SQLException {
        Connection connection =  DBCPUtils.getConnection();
        Statement statement = connection.createStatement();
        int rows=statement.executeUpdate("update userss set password='lisi'");
        System.out.println(rows);
    }

    public static void insert() throws Exception {
        Connection connection = DBCPUtils.getConnection();
        String sql = "insert into userss(username,password) values (?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setObject(1, "test");
        pst.setObject(2, "zhangsan");
        int rows = pst.executeUpdate();
        System.out.println(rows);
        DBCPUtils.closeALL(connection, pst, null);
    }

    public static void query() throws Exception{
        //获取数据库连接
        Connection connection = DBCPUtils.getConnection();
        //查询
        Statement statement = connection.createStatement();
        //返回结果集
        ResultSet resultSet=statement.executeQuery("select * from userss");
        while (resultSet.next()){
            Object username=resultSet.getObject("username");
            Object password=resultSet.getObject("password");
            System.out.println(username+"\t"+password);
        }
        DBCPUtils.closeALL(connection,statement,resultSet);
    }

}
