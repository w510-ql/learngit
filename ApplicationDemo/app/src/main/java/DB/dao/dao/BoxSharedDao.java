package DB.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DB.dao.model.BoxShared;
import DB.dao.util.DBUtil;

public class BoxSharedDao {
    // 转发提问箱
    public int add(BoxShared boxShared){
        String sql = "insert into boxSharedInfo(box_no,send_account,receive_account) values(?,?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1,Integer.valueOf(boxShared.getBox_no()));
            ps.setString(2,boxShared.getSend_account());
            ps.setString(3,boxShared.getRev_account());
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    // 找到某个用户收到的Box列表
    public List<BoxShared> selectFromReciver(String key){
        BoxShared boxshared = null;
        String sql = "select * from boxSharedInfo where receive_account ="+key;
        ArrayList list = new ArrayList<BoxShared>();

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String box_no = rs.getString(1);
                String send_account = rs.getString(2);
                String received_account = rs.getString(3);
                Timestamp send_time = rs.getTimestamp(4);
                boxshared = new BoxShared(box_no, send_account, received_account, send_time);
                list.add(boxshared);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
