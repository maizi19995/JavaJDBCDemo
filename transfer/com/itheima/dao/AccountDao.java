package com.itheima.dao;

/**
 * @author Maizi
 * @PackageName:com.itheima.dao
 * @ClassName: AccountDao
 * @Description:
 * @Date 2020/8/3 12:33
 */

import com.itheima.utils.C3P0Utils02;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 转账的DAO层,主要是操作数据库
 *
 * @author maizi
 *
 */
public class AccountDao {
    /**
     *     转账出去
     */
    public void fromAccount(Connection conn,String fromname, double money) throws SQLException {
        QueryRunner qr=new QueryRunner();
        qr.update(conn,"update account set money=money-? where name=?",money,fromname);

    }
    /**
     * 收到钱
     */
    public void toAccount(Connection conn,String toname,double money)throws SQLException{
        QueryRunner qr=new QueryRunner();
        qr.update(conn,"update account set money=money+? where name =?",money,toname);
    }
}
