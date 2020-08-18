package com.itheima.view;

import com.itheima.service.AccountService;
import com.itheima.service.AccountService02;

/**
 * @author Maizi
 * @PackageName:com.itheima.view
 * @ClassName: AccountView
 * @Description:
 * @Date 2020/8/3 12:55
 */
public class AccountView02 {
    public static void main(String[] args) {
        //模拟转账
        String fromName="jack";
        String toName="rose";
        double money=1000;

        AccountService02 accountService=new AccountService02();
        accountService.transfer(fromName,toName,money);
    }
}
