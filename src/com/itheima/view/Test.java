package com.itheima.view;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.C3P0Utils02;
import com.itheima.utils.C3P0Utils02_03;

import java.rmi.activation.ActivationDesc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Maizi
 * @PackageName:com
 * @ClassName: Test
 * @Description:
 * @Date 2020/8/10 14:30
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("欢迎来到商品管理系统,请输入一下命令进行操作");
        while (true) {
            System.out.println("C:新增 U:修改 D:删除 DA:批量删除 FI:查询 FA:查询所有 Q:退出");
            Scanner scanner = new Scanner(System.in);
            String userSelect = scanner.nextLine();

            //判断用户输入
            switch (userSelect.toUpperCase()) {
                case "C":
                    //新增商品
                    addProduct();
                    break;
                case "U":
                    //修改商品功能
                    updateProduct();
                    break;
                case "D":
                    //删除商品功能(根据ID)
                    deleteProduct();
                    break;
                case "DA":
                    //批量删除功能
                    deleteAllProduct();
                    break;
                case "FI":
                    //根据ID查询
                    findById();
                    break;
                case "FA":
                    //查询所有商品
                    findAll();
                    break;
                case "Q":
                    //退出
                    quite();
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
                    break;
            }
        }
    }

    private static void addProduct() {
        System.out.println("您选择了新增商品功能!");
        System.out.println("请输入新的商品名字");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("输入新的商品价格:");
        int prince = Integer.parseInt(scanner.nextLine());
        //封装成商品对象
        Product product = new Product(name, prince);
        //调用Service层的添加商品方法
        ProductService service = new ProductService();
        service.addProduct(product);
        System.out.println("商品添加成功");
    }

    private static void updateProduct() {
        System.out.println("您选择了修改商品功能!");
        System.out.println("请输入要修改的商品编号");
        Scanner scanner = new Scanner(System.in);
        int pid = Integer.parseInt(scanner.nextLine());
        //查询 ,如果有,则显示,无,则返回不存在
        ProductService service = new ProductService();
        Product product = service.findById(pid);
        if (product == null) {
            System.out.println("商品未查到");
        } else {
            System.out.println("您要修改的商品信息如下");
            System.out.println(product);
            System.out.println("请输入商品新的名字");
            String newName = scanner.nextLine();
            System.out.println("请输入商品新的价格");
            int newPrice = Integer.parseInt(scanner.nextLine());

            product.setPname(newName);
            product.setPrice(newPrice);
            //调用Service
            service.updateProduct(product);
            System.out.println("修改商品成功");
        }


    }

    private static void deleteProduct() {
        System.out.println("您选择了删除商品功能!");
        System.out.println("请输入要删除的商品编号");
        Scanner scanner = new Scanner(System.in);
        int id = Integer.parseInt(scanner.nextLine());
        ProductService service = new ProductService();
        Product product = service.findById(id);
        if (product == null) {
            System.out.println("没有查到此商品");
        } else {
            System.out.println("您要删除的商品如下:");
            System.out.println(product);
            System.out.println("您确定要删除吗? y/n");
            String isOrNot = scanner.nextLine();
            if (isOrNot.toLowerCase().equals("y")) {
                service.deleteById(id);
                //System.out.println(1/0);
                System.out.println("删除成功!");
            } else {
                System.out.println("操作取消");
            }


        }

    }

    private static void deleteAllProduct() {
        System.out.println("您选择了批量删除商品功能!");
        //创建集合,保存要删除的商品的id
        ProductService service = new ProductService();
        List<Integer> ids = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您要删除的商品的编号(-1结束)");
            int deleteId = Integer.parseInt(scanner.nextLine());
            if (deleteId == -1) {
                break;
            } else {
                //判断id值的商品
                Product product = service.findById(deleteId);
                if (product != null) {
                    System.out.println("已经标记此商品...");
                    ids.add(deleteId);
                } else {
                    System.out.println("此商品不存在,请重新输入!");
                }
            }
        }
            if (ids.isEmpty()) {
                System.out.println("批量删除操作已经取消...");
            } else {
                System.out.println("您确定都要删除吗? y/n");
                String isOrNot = scanner.nextLine();
                if (isOrNot.toLowerCase().equals("y")) {
                    service.deleteAll(ids);
                    System.out.println("批量删除" + ids.size() + "个商品成功!");
            }
        }

    }

    private static void findById() {

        System.out.println("您选择了查询商品功能!");
        System.out.println("请输入您要查询的商品ID");
        Scanner scanner = new Scanner(System.in);
        int pid = Integer.parseInt(scanner.nextLine());
        //调用service的查询方法
        ProductService service = new ProductService();
        Product product = service.findById(pid);
        if (product == null) {
            System.out.println("查询的商品不存在");
        } else {
            System.out.println(product);
            System.out.println("商品查询成功");
        }

    }

    private static void findAll() {
        System.out.println("您选择了查询商品功能!");
        ProductService service = new ProductService();
        List<Product> ps = service.findAll();
        if (ps.isEmpty()) {
            System.out.println("数据库中没有数据");
        } else {
            for (Product p :
                    ps) {
                System.out.println(p);
            }
            System.out.println("所有商品显示完毕!");
        }

    }

    private static void quite() {
        System.out.println("您选择了退出!");
    }
}
