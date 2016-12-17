package net.nyist.jdbc.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc04Insert {

    public static void main(String[] args) throws Exception {
        //1安装客户端
        Class.forName("com.mysql.jdbc.Driver");
        //2 链接到数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        //3 创建sql输入界面
        Statement stmt = conn.createStatement();
        //4输入sql并提交
        String sql = "insert into t_user(name,pwd,age) values('w8','456',28)";
        //5 执行返回受影响的行数
        int result = stmt.executeUpdate(sql);
        System.out.println(result);
        //7 关闭
        stmt.close();
        conn.close();

    }

}
