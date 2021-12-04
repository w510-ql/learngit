package DB.dao.model;

import java.sql.Timestamp;

public class User {
    private String account;
    private String name;
    private String password;
    private Timestamp create_time;

    User(){}
    public User(String account, String name, String password){
        this.account = account;
        this.name = name;
        this.password = password;
    }
    public User(String account, String name, String password, Timestamp create_time){
        this.account = account;
        this.name = name;
        this.password = password;
        this.create_time = create_time;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
