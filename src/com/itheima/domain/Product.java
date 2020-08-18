package com.itheima.domain;

/**
 * @author Maizi
 * @PackageName:com.itheima.domain
 * @ClassName: Proudct
 * @Description:
 * @Date 2020/8/11 13:54
 */
public class Product {
    private int pid;
    private String pname;
    private int price;
    private String flag;
    private String category_id;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", flag='" + flag + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }

    public Product(int pid, String pname, int price, String flag, String category_id) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.flag = flag;
        this.category_id = category_id;
    }

    public Product() {
    }

    public Product(String pname, int price) {
        this.pname = pname;
        this.price = price;
    }
}
