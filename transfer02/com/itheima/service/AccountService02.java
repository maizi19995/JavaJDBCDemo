package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.dao.AccountDao02;
import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.ConnectionManager;

import java.io.IOException;
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
public class AccountService02 {
    //转账业务
    public void transfer(String fromName,String toName,double money){
        //直接调用DAO
        AccountDao02 dao=new AccountDao02();
        //转出去
        try {
            ConnectionManager.start();
            //转出去
            dao.fromAccount(fromName,money);
            //异常
            //System.out.println(1/0);
            //转出去
            dao.toAccount(toName,money);
            ConnectionManager.commit();
            System.out.println("转账成功");
        } catch (SQLException e) {
           // e.printStackTrace();
            System.out.println("程序出现异常,程序回滚");
            //回滚事务
            try {
                ConnectionManager.rollback();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        finally {
            try {
                ConnectionManager.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
