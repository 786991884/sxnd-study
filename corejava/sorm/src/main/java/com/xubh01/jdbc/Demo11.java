package com.xubh01.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 测试使用JDBCUtil工具类来简化JDBC开发
 */
public class Demo11 {


    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getMysqlConn();

            ps = conn.prepareStatement("insert into t_user (username) values (?)");
            ps.setString(1, "gaoqi");
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, ps, conn);
        }
    }
}
