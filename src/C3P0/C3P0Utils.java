package C3P0;

/**
 * @author Maizi
 * @PackageName:C3P0
 * @ClassName: C3P0Utils
 * @Description:
 * @Date 2020/7/28 16:26
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 给用户提供连接
 */
public class C3P0Utils {
    private static ComboPooledDataSource ds=new ComboPooledDataSource();
    //static 代码块设置数据库连接的四大要素
    static{
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localHost:3306/day04?useUnicode=true&characterEncoding=UTF-8");
            ds.setUser("root");
            ds.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws SQLException {
        //获取连接
        return ds.getConnection();
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
