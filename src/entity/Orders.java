package entity;

import java.util.Date;

/**
 * Created by tyr on 2017/5/28.
 */
public class Orders {
    private String oid;
    private String sid;
    private String bid;

    public Orders() {
    }

    public Orders(String oid, String sid, String bid) {
        this.oid = oid;
        this.sid = sid;
        this.bid = bid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
