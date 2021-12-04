package DB.dao.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import DB.dao.model.User;
import DB.dao.util.DBUtil;

public class UserDao {
    public int add(User user){
        String sql = "insert into userInfo(`account`,`name`,`password`) values(?,?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,user.getAccount());
            ps.setString(2,user.getName());
            ps.setString(3,user.getPassword());
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    // User支持修改名称
    public int update(Connection con, User t, String newName){
        String sql = "update userInfo set name=? where account = ?";
        int rows = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,newName);
            ps.setString(2, t.getAccount());
            rows = ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    public User select(String key){
        User user = null;
        String sql = "select * from userInfo where account ="+key;
        try(Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String account = rs.getString(1);
                String name = rs.getString(2);
                String pw = rs.getString(3);
                Timestamp ts = rs.getTimestamp(4);
                user = new User(account, name, pw, ts);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return user;
    }

}
