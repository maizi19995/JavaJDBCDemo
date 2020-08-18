package domain;

/**
 * @author Maizi
 * @PackageName:domain
 * @ClassName: Category
 * @Description:
 * @Date 2020/7/29 11:21
 */
public class Category {
    private String cid;
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
