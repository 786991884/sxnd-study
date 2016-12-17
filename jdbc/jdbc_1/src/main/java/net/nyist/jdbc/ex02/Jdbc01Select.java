package net.nyist.jdbc.ex02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc01Select {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、安装客户端---注册驱动（DriverManager）
        //Class.forName("com.mysql.jdbc.Driver");
        //2、填写链接信息
        // Connection conn=	DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Connection conn = JdbcUtil.getConnection();
        //3会得到一个“窗口”
        Statement stmt = conn.createStatement();
        // 4输入sql数据
        String sql = "select * from t_user";
        //5 执行---结果集窗口
        ResultSet rs = stmt.executeQuery(sql);
        //6遍历结果集
        while (rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }
        //7、释放资源
        /*rs.close();
	    stmt.close();
	    conn.close();*/
        JdbcUtil.free(rs, stmt, conn);

    }

}
