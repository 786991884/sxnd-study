package jdbc04;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 行集的填充2：
 * 行集对象自己连接数据库填充数据
 */
public class TestJDBC4 {
	public static void main(String[] args) {
		try {
			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.setUrl("jdbc:mysql://localhost:3306/test");
			rowset.setUsername("root");
			rowset.setPassword("1234");
			rowset.setCommand("select * from student");
			rowset.execute();

			System.out.println("使用行集连接数据库并填充数据，从行集中输出数据：");
			System.out.println("id\tname\tage");
			while (rowset.next()) {
				System.out.print(rowset.getInt(1) + "\t");
				System.out.print(rowset.getString(2) + "\t");
				System.out.print(rowset.getInt(3) + "\n");
			}

			rowset.close(); // 关闭行集
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}