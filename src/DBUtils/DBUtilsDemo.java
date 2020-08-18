package DBUtils;

/**
 * @author Maizi
 * @PackageName:DBUtils
 * @ClassName: DBUtilsDemo
 * @Description:
 * @Date 2020/7/29 11:20
 */

import C3P0.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBUtils框架的介绍
 * DBUtils类:主要负责关闭连接,释放资源,开启事务等操作
 * QueryRunner:负责我们对数据库的CURD操作(核心类)
 * ResultSetHandler:结果集处理类,帮我们处理结果集(封装数据);
 * QueryRunner类:
 *      构造:
 *      public QueryRunner(DataSource ds);//需要一个连接池
 *      public QueryRunner();//不需要一个连接池\
 *      方法:
 *      update(String sql,Object params);//主要执行增删改
 *      query(String sql,ResultSetHandler<T>,Object params);//主要执行查询
 *
 *
 */
public class DBUtilsDemo {
    public static void main(String[] args) throws SQLException {
        //insert();
        //delete();
        //update();
        query();
    }
    public static void insert() throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());

        //插入

        int rows=qr.update("insert into category(cname)values(?)","maizi");
        System.out.println(rows);

    }
    public static void delete() throws SQLException {
        //创建QueryRunner对像,给定连接池
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行
        int rows=qr.update("delete  FROM category where cid=?",12);
        System.out.println(rows);
    }
    public static void update() throws SQLException {
        //创建QueryRunner对像,给定连接池
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行
        int rows=qr.update("update  category set   cname=? where cid=13","茄子");
        System.out.println(rows);
    }
    public static void query() throws SQLException {
        //创建QueryRunner对象,给定连接池
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
//        ResultSet  resultSet=qr.query("select * from category");
//        while(resultSet.next()){
//            System.out.println(resultSet.getObject("cid")+"\t"+resultSet.getObject("cname"));
//        }
    }
}
