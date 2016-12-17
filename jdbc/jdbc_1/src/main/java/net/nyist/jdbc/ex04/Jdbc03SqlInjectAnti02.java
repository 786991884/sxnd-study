package net.nyist.jdbc.ex04;

import net.nyist.jdbc.ex03.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1、sql inject 2、多次使用同一个语句时候，第二种效率高--->推荐大家使用
 */
public class Jdbc03SqlInjectAnti02 {

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
        login("' or 1=1 or '", "");

    }

    public static void login(String uname, String pwd) {
        // 首先定义三个
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            // 采用占位符方式书写
            String sql = "select * from t_user  where name=? and pwd=?";
            stmt = conn.prepareStatement(sql);
            // 给占位符赋值，注意编号是从1开始
            stmt.setString(1, uname);
            stmt.setString(2, pwd);
            // 执行前必须赋值才能执行
            rs = stmt.executeQuery();
            System.out.println(sql);
            if (rs.next()) {
                System.out.println("用户存在");
            } else {
                System.out.println("用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.free(rs, stmt, conn);
        }
    }
}
