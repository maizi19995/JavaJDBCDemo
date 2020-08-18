package JDBCTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maizi
 * @PackageName:JDBCTest
 * @ClassName: TestDemo
 * @Description:
 * @Date 2020/7/24 23:31
 */
public class TestDemo {
    public static void main(String[] args){
        Connection connection= null;
        Statement statement = null;
        ResultSet rs= null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select*from category");
            while(rs.next()){
                Object cid=rs.getObject("cid");
                Object cname=rs.getObject("cname");
                System.out.println(cid+"\t" +cname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeALL(connection,statement,rs);
        }
    }
}
