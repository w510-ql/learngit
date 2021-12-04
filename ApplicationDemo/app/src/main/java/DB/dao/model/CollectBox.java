package DB.dao.model;

import java.sql.Timestamp;

public class CollectBox {
    private String account;
    private String box_no;
    private Timestamp create_time;

    public CollectBox(String account, String box_no){
        this.account = account;
        this.box_no = box_no;
    }
    public CollectBox(String account, String box_no, Timestamp create_time){
        this.account = account;
        this.box_no = box_no;
        this.create_time = create_time;
    }

    public String getAccount() {
        return account;
    }

    public String getBox_no() {
        return box_no;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    //set
    public void setAccount(String account) {
        this.account = account;
    }

    public void setBox_no(String box_no) {
        this.box_no = box_no;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

}
