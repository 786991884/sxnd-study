package net.nyist.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPTest {

    public static void main(String[] args) {
        //建立连接池对象
        BasicDataSource bds = new BasicDataSource();
        //2、链接到数据库的必须细腻
        bds.setUrl("jdbc:mysql://localhost:3306/test");
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        //3 链接的配置
        bds.setInitialSize(3);
        bds.setMaxIdle(10);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = bds.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from t_user");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();//把连接放回到链接池中
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                bds.close();//关闭所有Connection，
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
