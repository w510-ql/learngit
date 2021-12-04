package DB.dao.model;

import java.sql.Timestamp;

public class Box {
    private String no;
    private String create_account;
    private String title;
    private Timestamp create_time;
    private Timestamp end_time;

    Box(){}
    public Box(String create_account, String title){
        this.create_account = create_account;
        this.title = title;
    }

    public Box(String no, String create_account, String title, Timestamp create_time, Timestamp end_time){
        this.no = no;
        this.create_account = create_account;
        this.title = title;
        this.create_time = create_time;
        this.end_time = end_time;
    }

    //get
    public String getNo() {
        return no;
    }

    public String getCreate_account() {
        return create_account;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setNo(String no) {
        this.no = no;
    }

    //set
    public void setCreate_account(String create_account) {
        this.create_account = create_account;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Box{" +
                "no='" + no + '\'' +
                ", create_account='" + create_account + '\'' +
                ", title='" + title + '\'' +
                ", create_time=" + create_time +
                ", end_time=" + end_time +
                '}';
    }
}
