package DB.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.dao.model.Box;
import DB.dao.model.CollectBox;
import DB.dao.util.DBUtil;

public class CollectBoxDao {
    public int add(CollectBox collectBox){
        String sql = "insert into collectBoxInfo(account,box_no) values(?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,collectBox.getAccount());
            ps.setInt(2,Integer.valueOf(collectBox.getBox_no()));
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    // 删除
    public int delete(CollectBox collectBox){
        String sql = "delete from collectBoxInfo where account="+collectBox.getAccount()+" and box_no="+collectBox.getBox_no();
        int rows=0;
        try (Connection con= DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            rows = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    // select
    public List<Box> selectFromOwner(String account){
        List<Box> collectBList = new ArrayList<>();
        String sql = "select * from boxInfo where no in (" +
                "select box_no from collectBoxInfo where account=" + account+")";
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                collectBList.add(new Box(rs.getString(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getTimestamp(5)));
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return collectBList;
    }

}
