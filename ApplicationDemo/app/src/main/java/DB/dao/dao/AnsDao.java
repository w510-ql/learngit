package DB.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import DB.dao.model.Ans;
import DB.dao.util.DBUtil;

public class AnsDao {
    // 答复
    public int add(Ans ans){
        String sql = "insert into AnsInfo(ask_no,content) values(?,?);";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,ans.getAsk_no());
            ps.setString(2,ans.getContent());
            rows = ps.executeUpdate();
            Statement st = con.createStatement();
            st.execute("update `QuesInfo` set `isAns`=1 where `no`="+ans.getAsk_no());

        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }



}
