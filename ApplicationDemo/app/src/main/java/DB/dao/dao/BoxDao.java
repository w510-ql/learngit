package DB.dao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import DB.dao.model.Box;
import DB.dao.util.DBUtil;

public class BoxDao {
    public int add(Box box){
        String sql = "insert into boxInfo(create_account,title,end_time) values(?,?,?)";
        int rows = 0;
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1,box.getCreate_account());
            ps.setString(2,box.getTitle());
            ps.setTimestamp(3, box.getEnd_time());
            rows = ps.executeUpdate();
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    // 删除
    public int delete(Box box){
        String sql = "delete from boxInfo where no="+box.getNo();
        int rows=0;
        try (Connection con= DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);){
            rows = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // 修改title
    public int update(Connection con, Box box, String newTitle){
        String sql = "update boxInfo set title=? where no=?";
        int rows = 0;
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,newTitle);
            ps.setInt(2,Integer.valueOf(box.getNo()));
            rows = ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rows;
    }

    public Box select(String key){
        Box box = null;
        String sql = "select * from boxInfo where no ="+key;
        System.out.println("BoxDao's select: "+sql);
        try(Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String no = rs.getString(1);
                String create_account = rs.getString(2);
                String title = rs.getString(3);
                System.out.println("get title String: "+title);
//                String bytes = rs.getBlob(3).toString();
//                String title = new String(bytes.getBytes(bytes),"utf-8");
                Timestamp create_time = rs.getTimestamp(4);
                Timestamp end_time = rs.getTimestamp(5);
                box = new Box(no, create_account, title.trim(), create_time, end_time);
            }
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return box;
    }

//    public
}
