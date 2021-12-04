package DB.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    // 与数据库连接
    public static Connection getConnection() throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://gz-cdb-famig12l.sql.tencentcdb.com:57830/db_lizhiBox?useUnicode=true&characterEncoding=UTF-8 && serverTimezone=GMT";
        String user = "admin";
        String ps = "admin123";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,ps);
        } catch(SQLException e){
            System.out.println("与数据库连接失败");
            e.printStackTrace();
        }
        return con;
    }

    // 关闭数据库连接
    public static void close(Connection con, PreparedStatement ps){
        try{
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        } catch (SQLException e){
            System.out.println("数据库关闭失败");
            e.printStackTrace();
        }
    }

    public  static void close(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch(SQLException e){
            System.out.println("数据库关闭失败");
            e.printStackTrace();
        }
    }

}
