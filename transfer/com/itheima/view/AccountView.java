package com.itheima.view;

import com.itheima.service.AccountService;

/**
 * @author Maizi
 * @PackageName:com.itheima.view
 * @ClassName: AccountView
 * @Description:
 * @Date 2020/8/3 12:55
 */
public class AccountView {
    public static void main(String[] args) {
        //模拟转账
        String fromName="jack";
        String toName="rose";
        double money=1000;

        AccountService accountService=new AccountService();
        accountService.transfer(fromName,toName,money);
    }
}
