package DBUtils;

/**
 * @author Maizi
 * @PackageName:DBUtils
 * @ClassName: DBUtilsDemo
 * @Description:
 * @Date 2020/7/29 11:20
 */

import C3P0.C3P0Utils;
import C3P0.C3P0Utils02;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 这个类用来执行数据库的查询操作.
 */
public class DBUtilsDemo02 {
    public static void main(String[] args) throws SQLException {
        //demo01();
      //  demo02();
       // demo03();
       // demo04();
       // demo05();
      //  demo06();
        //demo07();
        demo08();
    }

    /**
     * ArrayHandle处理类的使用
     * @throws SQLException
     */
    public static void demo01() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        //第一种
        String sql="select * from category where cid=13";
        Object[]objects=qr.query(sql,new ArrayHandler());
        //第二种方法
        String sql2="select * from category where cid=?";
        Object[] object={13};
        Object[]    objects1=qr.query(sql2,new ArrayHandler(),object);
        for (Object obj:
                objects1 ) {
            System.out.println(obj);
        }
    }
    /**
     * ArrayListHandle处理类的使用
     * @throws SQLException
     */
    public static void demo02() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        List<Object[]>list=qr.query(sql2,new ArrayListHandler());
        for (Object[] obj:
                list ) {
            System.out.println(obj[0]+"\t"+obj[1]);
        }
    }

    /**
     * BeanHandler处理类的使用
     * @throws SQLException
     */
    public static void demo03() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        Category category = qr.query(sql2, new BeanHandler<Category>(Category.class));
        System.out.println(category);
    }

    /**
     * BeanListHandler处理类的使用
     * @throws SQLException
     */
    public static void demo04() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        List<Category> list= qr.query(sql2, new BeanListHandler<Category>(Category.class));
        System.out.println(list);
        for (Category ca :
                list) {
            System.out.println(ca);
        }
    }
    /**
     * ColumnListHandle处理类的使用
     * @throws SQLException
     */
    public static void demo05() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        List<Integer> list= qr.query(sql2, new ColumnListHandler<>("cid"));
        System.out.println(list);
    }
    /**
     * MapHandler处理类的使用
     * @throws SQLException
     */
    public static void demo06() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        Map<String,Object>map=qr.query(sql2,new MapHandler());
        System.out.println(map);
    }
    /**
     * MapListHandler处理类的使用
     * @throws SQLException
     */
    public static void demo07() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select * from category";
        List<Map<String,Object>>map=qr.query(sql2,new MapListHandler());
        System.out.println(map);
    }
    /**
     * ScalarHandler处理类的使用
     * @throws SQLException
     */
    public static void demo08() throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());
        //执行查询
        String sql2="select count(*)from category";
        Long count=qr.query(sql2,new ScalarHandler<Long>());
        System.out.println(count);
    }
}
