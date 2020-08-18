package DBCP;

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
public class DBCPUtils_03 {

    private static DataSource ds =null;

    //设置DS的四大要素
    static {
        /**
         * 修改配置文件到src目录下,如何找到配置文件
         */

//        ds.setDriverClassName(ps.getProperty("driverName"));
//        ds.setUrl(ps.getProperty("url"));
//        ds.setUsername(ps.getProperty("username"));
//        ds.setPassword(ps.getProperty("password"));
        Properties ps=new Properties();
        try {
            //获取类加载器,,将src的资源变成流,默认路径是src
            ps.load(DBCPUtils_03.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
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
