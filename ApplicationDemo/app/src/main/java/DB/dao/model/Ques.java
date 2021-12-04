package DB.dao.model;

import java.sql.Timestamp;

public class Ques {
    private String no;
    private String box_no;
    private String ask_name;
    private String content;
    private Timestamp create_time;
    private boolean isAns=false;

    public Ques(String box_no, String content){
        this.box_no = box_no;
        this.content = content;
    }
    public Ques(String no, String box_no, String content){
        this.no = no;
        this.box_no = box_no;
        this.content = content;
    }

    public Ques(String no, String box_no, String ask_name, String content, Timestamp create_time, boolean isAns){
        this.no = no;
        this.box_no = box_no;
        this.ask_name = ask_name;
        this.content = content;
        this.create_time = create_time;
        this.isAns = isAns;
    }

    //get
    public String getNo() {
        return no;
    }

    public String getBox_no() {
        return box_no;
    }

    public String getAsk_name() {
        return ask_name;
    }

    public String getContent() {
        return content;
    }

    public boolean getisAns() { return isAns; }

    public Timestamp getCreate_time() {
        return create_time;
    }
    // set
    public void setBox_no(String box_no) {
        this.box_no = box_no;
    }

    public void setAsk_name(String ask_name) {
        this.ask_name = ask_name;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setAns(boolean ans) {
        isAns = ans;
    }

    @Override
    public String toString() {
        return "Ques{" +
                "no='" + no + '\'' +
                ", box_no='" + box_no + '\'' +
                ", ask_name='" + ask_name + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", isAns=" + isAns +
                '}';
    }
}
