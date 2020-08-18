package C3P0;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maizi
 * @PackageName:C3P0
 * @ClassName: C3P0UtilsTestDemo
 * @Description:
 * @Date 2020/7/28 16:51
 */
public class C3P0UtilsTestDemo02 {
    public static void main(String[] args) throws SQLException {

       Connection connection =C3P0Utils02.getConnection();
        System.out.println(connection);
    }
}
