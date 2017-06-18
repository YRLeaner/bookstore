package entity;

/**
 * Created by tyr on 2017/6/4.
 */
public class Recomended {
    public String rid;
    public String sid;

    public Recomended() {
    }

    public Recomended(String rid, String sid) {
        this.rid = rid;
        this.sid = sid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
