package DBCP;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Maizi
 * @PackageName:DBCP
 * @ClassName: DBCPUtils_02
 * @Description:
 * @Date 2020/7/28 6:36
 */
public class DBCPUtils_02 {

    private static DataSource ds =null;

    //设置DS的四大要素
    static {
        /**
         * 带有配置问题的DBCP的使用
         * 核心类 BasicDataSourceFactory()
         */

//        ds.setDriverClassName(ps.getProperty("driverName"));
//        ds.setUrl(ps.getProperty("url"));
//        ds.setUsername(ps.getProperty("username"));
//        ds.setPassword(ps.getProperty("password"));
//        Properties ps=new Properties();
        Properties ps=new Properties();
        try {
            ps.load(DBCPUtils_02.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
            ds=BasicDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
