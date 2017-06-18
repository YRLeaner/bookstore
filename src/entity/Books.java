package entity;

import java.util.Date;

/**
 * Created by tyr on 2017/5/28.
 */
public class Books {
    private String bid;
    private String bname;
    private String address;
    private Date birthday;
    private String price;

    public Books() {
    }

    public Books(String address, String bname, String bid, Date birthday, String price) {
        this.address = address;
        this.bname = bname;
        this.bid = bid;
        this.birthday = birthday;
        this.price = price;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", price='" + price + '\'' +
                '}';
    }
}
