package DB.dao.model;

import java.sql.Timestamp;

public class Ans {
    private String ask_no;
    private String ans_no;
    private String content;
    private Timestamp create_time;
    public Ans(String ask_no, String content){
        this.ask_no = ask_no;
        this.content = content;
    }
    public Ans(String ask_no, String ans_no, String content){
        this.ask_no = ask_no;
        this.ans_no = ans_no;
        this.content = content;
    }
    public Ans(String ask_no, String ans_no, String content, Timestamp create_time){
        this.ask_no = ask_no;
        this.ans_no = ans_no;
        this.content = content;
        this.create_time = create_time;
    }

    //get
    public String getAsk_no() {
        return ask_no;
    }

    public String getAns_no() {
        return ans_no;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    //set
    public void setAsk_no(String ask_no) {
        this.ask_no = ask_no;
    }

    public void setAns_no(String ans_no) {
        this.ans_no = ans_no;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
