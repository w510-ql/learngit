package DB.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DB.dao.model.Ques;
import DB.dao.util.DBUtil;

public class QuesDao {
    // 实名提问
    public int addWithName(Ques ques){
        String sql = "insert into QuesInfo values(?,?,?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, ques.getNo());
            ps.setString(2,ques.getBox_no());
            ps.setString(3,ques.getAsk_name());
            ps.setString(4,ques.getContent());
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }
    //匿名提问
    public int addWithoutName(Ques ques){
        String sql = "insert into QuesInfo(box_no, content) values(?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,ques.getBox_no());
            ps.setString(2,ques.getContent());
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    // 获取提问箱所有提问
    public List<Ques> selectFromBoxNo(String key){
        Ques ques = null;
        String sql = "select * from QuesInfo where box_no ="+key;
        List list = new ArrayList<Ques>();

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String no = rs.getString(1);
                String box_no = rs.getString(2);
                String ask_name = rs.getString(3);
                String content = rs.getString(4);
                Timestamp create_time = rs.getTimestamp(5);
                boolean isAns = rs.getBoolean(6);
                ques = new Ques(no, box_no, ask_name, content, create_time, isAns);
                list.add(ques);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    // 获取为回复的提问
    public List<Ques> selectFromBoxNoWithoutAns(String key){
        Ques ques = null;
        String sql = "select * from QuesInfo where box_no ="+key+" and isAns=0";
        List list = new ArrayList<Ques>();

        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String no = rs.getString(1);
                String box_no = rs.getString(2);
                String ask_name = rs.getString(3);
                String content = rs.getString(4);
                Timestamp create_time = rs.getTimestamp(5);
                boolean isAns = rs.getBoolean(6);
                ques = new Ques(no, box_no, ask_name, content, create_time, isAns);
                list.add(ques);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
