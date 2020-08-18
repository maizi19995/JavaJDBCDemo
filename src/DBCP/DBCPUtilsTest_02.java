package DBCP;

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
public class DBCPUtilsTest_02 {
    public static void main(String[] args){
        Connection connection= null;
        Statement statement = null;
        ResultSet rs= null;
        try {
            connection = DBCPUtils.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select*from userss");
            while(rs.next()){
                Object cid=rs.getObject("username");
                Object cname=rs.getObject("password");
                System.out.println(cid+"\t" +cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtils_02.closeALL(connection,statement,rs);
        }
    }
}
