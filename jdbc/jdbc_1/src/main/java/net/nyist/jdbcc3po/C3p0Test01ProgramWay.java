package net.nyist.jdbcc3po;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * c3po数据源使用方式有三种：1）ComboPooledDataSource 2）DataSources工厂类 3)
 * 创建PoolBackedDataSource 并设置它的 ConectionPoolDataSource
 */
public class C3p0Test01ProgramWay {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //下面是以编程方式创建
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
            cpds.setUser("root");
            cpds.setPassword("root");
            cpds.setInitialPoolSize(10);
            conn = cpds.getConnection();
            System.out.println(conn.getClass());
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from t_user");
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (Exception e) {
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
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}
