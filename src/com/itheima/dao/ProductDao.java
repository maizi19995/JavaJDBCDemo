package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils02_03;
import com.itheima.utils.ConnectionManager_02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品的Dao层
 * @author Maizi
 * @PackageName:com.itheima.dao
 * @ClassName: ProductDao
 * @Description:
 * @Date 2020/8/11 14:10
 */
public class ProductDao {
    public void addProduct(Product product) throws SQLException {
        //创建QueryRunner对象
            QueryRunner queryRunner = new QueryRunner(C3P0Utils02_03.getDataSource());
            Object[]params={product.getPname(),product.getPrice(),"1","c002"};
            queryRunner.update("insert into products (pname,price,flag,category_id) values(?,?,?,?)",params);

    }

    public Product findById(int id) throws SQLException {
        //创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner(C3P0Utils02_03.getDataSource());
        //调用qr的query
        Product product=queryRunner.query("select * from products where pid=?",new BeanHandler<Product>(Product.class),id);
        return product ;
    }

    public void updateProduct(Product product) throws SQLException {
        //创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner(C3P0Utils02_03.getDataSource());
        //调用qr的update
        queryRunner.update("update products set pname=?,price =? where pid=?;",product.getPname(),product.getPrice(),product.getPid());
    }

    public List<Product> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils02_03.getDataSource());
        List <Product> ps=queryRunner.query("select * from products;",new BeanListHandler<Product>(Product.class));
        return ps;
    }
    public void deleteById(int id) throws SQLException {
        //创建QueryRunner对象
        QueryRunner queryRunner=new QueryRunner();
        queryRunner.update(ConnectionManager_02.getConnection(),"delete from products where pid=?",id);
    }
}
