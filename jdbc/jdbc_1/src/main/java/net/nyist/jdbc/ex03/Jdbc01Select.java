package net.nyist.jdbc.ex03;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc01Select {

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException {
        //首先定义三个
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from t_user1");
            while (rs.next()) {
                int age = rs.getInt("age");
                String name = rs.getString("name");
                System.out.println("age=" + age + "\tname=" + name);
            }
        } catch (SQLException e) {
            System.out.println("Error code=" + e.getErrorCode());
            System.out.println("error state=" + e.getSQLState());
            System.out.println("error desc=" + e.getMessage());
        } finally {
            JdbcUtil.free(rs, stmt, conn);
        }

    }

}
