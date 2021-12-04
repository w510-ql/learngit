package DB.dao.model;

import java.sql.Timestamp;

public class QuesAndAns {
    private String ques_con;
    private String ask_name;
    private String ans_con;
    private Timestamp create_time;

    QuesAndAns(){}
    public QuesAndAns(String ques_con, String ask_name, String ans_con, Timestamp create_time){
        this.ques_con = ques_con;
        this.ask_name = ask_name;
        this.ans_con = ans_con;
        this.create_time = create_time;
    }
    public String getAns_con() {
        return ans_con;
    }

    public String getQues_con() {
        return ques_con;
    }

    public String getAsk_name() {
        return ask_name;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setAns_con(String ans_con) {
        this.ans_con = ans_con;
    }

    public void setQues_con(String ques_con) {
        this.ques_con = ques_con;
    }

    public void setAsk_name(String ask_name) {
        this.ask_name = ask_name;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
}
