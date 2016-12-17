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
public class C3p0Test02DeclearWay {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //声明方式
            //ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0-config.xml");
            //如果配置文件的名称为：c3p0-config.xml，这可以省略
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            conn = cpds.getConnection();
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
