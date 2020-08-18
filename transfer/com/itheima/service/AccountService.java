package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.utils.C3P0Utils02;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 转账业务层
 * @author Maizi
 * @PackageName:com.itheima.service
 * @ClassName: AccountService
 * @Description:
 * @Date 2020/8/3 12:43
 */
public class AccountService {
    //转账业务
    public void transfer(String fromName,String toName,double money){
        //直接调用DAO
        AccountDao dao=new AccountDao();
        Connection connection=null;
        //转出去
        try {
            connection= C3P0Utils02.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(4);
            //转出去
            dao.fromAccount(connection,fromName,money);
            //异常
            System.out.println(1/0);
            //转出去
            dao.toAccount(connection,toName,money);
            connection.commit();
            System.out.println("转账成功");
        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("程序出现异常,程序回滚");
            //回滚事务
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
