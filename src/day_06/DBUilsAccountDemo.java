package day_06;

import C3P0.C3P0Utils;
import C3P0.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Maizi
 * @PackageName:day_06
 * @ClassName: DBUilsAccountDemo
 * @Description:
 * @Date 2020/8/1 14:54
 */
public class DBUilsAccountDemo {


    public static void main(String[] args){
        //QueryRunner qr=new QueryRunner(C3P0Utils02.getDataSource());//为了支持事务,不能传递连接池
        QueryRunner qr=new QueryRunner();

        Connection connection= null;
        try {
            connection = C3P0Utils02.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //执行转账
            int rows1 = qr.update("update  account set money=money-? where name =?",1000,"jack");
            System.out.println(1/0);
            int rows2 = qr.update("update  account set money=money+? where name =?",1000,"rose");
            //提交事务

            if(rows1>0&&rows2>0){
                System.out.println("转账成功");
            }
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("转账失败");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
