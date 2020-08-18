package JDBCTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Maizi
 * @PackageName:JDBCTest
 * @ClassName: TestDemo2
 * @Description:
 * @Date 2020/7/25 20:38
 */
public class TestDemo2 {
    public static void main(String[] args) {
     //   insert();
   //     delete();
     //   update();
        query();
    }
    public static void insert(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            statement=connection.createStatement();
            int rows=statement.executeUpdate("insert into category (cname) value ('果汁'),('蔬菜'),('包子')");
            System.out.println("插入"+rows+"行");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeALL(connection,statement,null);
        }
    }

    public static void delete(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            statement=connection.createStatement();
            int rows=statement.executeUpdate("delete from category where cname='果汁'");
            System.out.println(rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeALL(connection,statement,resultSet);
        }
    }
    public static void update(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            statement=connection.createStatement();
            int rows=statement.executeUpdate("update category set cname='果汁2' where cid=11");
            System.out.println(rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeALL(connection,statement,resultSet);
        }
    }
    public static void query(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtils.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("select * from category where cid=12");
            while(resultSet.next()){
                Object cid=resultSet.getObject("cid");
                Object cname=resultSet.getObject("cname");
                System.out.println(cid+"\t"+cname);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeALL(connection,statement,resultSet);
        }
    }
}
