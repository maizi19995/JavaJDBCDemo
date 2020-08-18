package DBCP;

/**
 * @author Maizi
 * @PackageName:DBCP
 * @ClassName: DBCPUtils
 * @Description:
 * @Date 2020/7/28 6:10
 */

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 所有的连接池必须遵循javax.sql.DataSource接口
 * 在DBCP连接池中
 * 实现javax.sql.DataSource接口的实现类是:BasicDataSource;
 */
public class DBCPUtils {
//    private static String driverName = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://localHost:3306/day04?useUnicode=true&characterEncoding=UTF-8";
//    private static String username = "root";
//    private static String password = "root";
    private static BasicDataSource ds = new BasicDataSource();

    //设置DS的四大要素
    static {
        Properties ps=new Properties();
        try {
            ps.load(new FileInputStream("gjdbc_config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.setDriverClassName(ps.getProperty("driverName"));
        ds.setUrl(ps.getProperty("url"));
        ds.setUsername(ps.getProperty("username"));
        ds.setPassword(ps.getProperty("password"));
    }

    public static Connection getConnection() throws SQLException {
            return ds.getConnection();
    }

    public static void closeALL(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
