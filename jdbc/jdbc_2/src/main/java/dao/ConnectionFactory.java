package dao;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static ThreadLocal<Connection> conn = new ThreadLocal<Connection>();
    private static Properties pros = System.getProperties();

    static {
        try {
            InputStream is = ConnectionFactory.class
                    .getResourceAsStream("jdbc.properties");
            pros.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection con = conn.get();
        if (con == null) {
            try {
                DataSource ds = BasicDataSourceFactory.createDataSource(pros);
                con = ds.getConnection();
                conn.set(con);
            } catch (SQLException se) {
                se.printStackTrace();
                throw new RuntimeException(se);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return con;
    }

    public static void release() {
        Connection con = getConnection();
        if (con != null) {
            try {
                con.close();
            } catch (SQLException se) {
            }
        }

        conn.set(null);
    }

    // public static void main(String args[]) throws SQLException{
    // Connection conn=ConnectionFactory.getConnection();
    //
    // java.sql.PreparedStatement pstmt =
    // conn.prepareStatement("select last_insert_id()");
    // java.sql.ResultSet rs = pstmt.executeQuery();
    // rs.next();
    // System.out.println(rs.getLong(1));
    // }
}