package DBCP;

import JDBCTest.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maizi
 * @PackageName:DBCP
 * @ClassName: DBCPUtilsTest
 * @Description:
 * @Date 2020/7/28 6:25
 */
public class DBCPUtilsTest {
    public static void main(String[] args){
        Connection connection= null;
        Statement statement = null;
        ResultSet rs= null;
        try {
            connection = DBCPUtils_02.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select*from category");
            while(rs.next()){
                Object cid=rs.getObject("cid");
                Object cname=rs.getObject("cname");
                System.out.println(cid+"\t" +cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtils.closeALL(connection,statement,rs);
        }
    }
}
