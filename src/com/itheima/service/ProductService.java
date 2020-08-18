package com.itheima.service;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.C3P0Utils02_02;
import com.itheima.utils.ConnectionManager_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品的Service层
 *
 * @author Maizi
 * @PackageName:com.itheima.service
 * @ClassName: ProductService
 * @Description:
 * @Date 2020/8/11 14:05
 */
public class ProductService {
    /**
     * 添加商品
     *
     * @param product
     */
    public void addProduct(Product product) {
        ProductDao productDao = new ProductDao();
        try {
            productDao.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找商品
     *
     * @param pid
     * @return
     */
    public Product findById(int pid) {
        ProductDao dao = new ProductDao();
        Product product = null;
        try {
            product = dao.findById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    /**
     * 修改商品
     *
     * @param product
     * @return
     */
    public void updateProduct(Product product) {
        ProductDao dao = new ProductDao();
        try {
            dao.updateProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找所有商品
     *
     * @return
     */
    public List<Product> findAll() {
        ProductDao dao = new ProductDao();
        List<Product> ps = null;
        try {
            return dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    /**
     * 根据id删除商品
     */
    public void deleteById(int id) {
        ProductDao dao = new ProductDao();
        try {
            ConnectionManager_02.start();
            dao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ConnectionManager_02.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                ConnectionManager_02.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 批量删除商品
     */
    public void deleteAll(List<Integer> ids) {
        ProductDao dao = new ProductDao();

        try {
            ConnectionManager_02.start();
            for (int id :
                    ids) {
                dao.deleteById(id);
            }
            ConnectionManager_02.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                ConnectionManager_02.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }finally {
            try {
                ConnectionManager_02.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
