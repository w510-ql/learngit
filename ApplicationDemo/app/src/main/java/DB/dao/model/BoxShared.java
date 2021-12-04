package DB.dao.model;

import java.sql.Timestamp;

public class BoxShared {
    private String box_no;
    private String send_account;
    private String rev_account;
    private Timestamp send_time;

    BoxShared(){}
    public BoxShared(String box_no, String send_account, String rev_account){
        this.send_account = send_account;
        this.box_no = box_no;
        this.rev_account = rev_account;
    }
    public BoxShared(String send_account, String box_no, String rev_account, Timestamp send_time){
        this.send_account = send_account;
        this.box_no = box_no;
        this.rev_account = rev_account;
        this.send_time = send_time;
    }

    public String getSend_account() {
        return send_account;
    }

    public String getBox_no() {
        return box_no;
    }

    public String getRev_account() {
        return rev_account;
    }

    public Timestamp getSend_time() {
        return send_time;
    }

    //set
    public void setSend_account(String send_account) {
        this.send_account = send_account;
    }

    public void setRev_account(String rev_account) {
        this.rev_account = rev_account;
    }

    public void setBox_no(String box_no) {
        this.box_no = box_no;
    }

    public void setSend_time(Timestamp send_time) {
        this.send_time = send_time;
    }

    @Override
    public String toString() {
        return "BoxShared{" +
                "box_no='" + box_no + '\'' +
                ", send_account='" + send_account + '\'' +
                ", rev_account='" + rev_account + '\'' +
                ", send_time=" + send_time +
                '}';
    }
}
