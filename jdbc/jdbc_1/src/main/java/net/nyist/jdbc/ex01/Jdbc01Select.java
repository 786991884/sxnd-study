package net.nyist.jdbc.ex01;

import java.sql.*;

/**
 * 引入版本
 */
public class Jdbc01Select {

    public static void main(String[] args) {
        try {
            //1、安装客户端---注册驱动（DriverManager）
            Class.forName("com.mysql.jdbc.Driver");
            //2、填写链接信息
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            System.out.println(conn.getClass());
            //3创建一个输入SQl的“窗口”
            Statement stmt = conn.createStatement();
            //4输入sql数据
            String sql = "select * from t_user1";
            //5 执行---结果集窗口
            ResultSet rs = stmt.executeQuery(sql);
            //6遍历结果集
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            //7、释放资源---不健壮
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
