package jdbc04;

import com.sun.rowset.CachedRowSetImpl;

/*
 * 使用行集分页
 * 行集连接数据库并填充数据
 */
public class TestJDBC9 {
	public static void main(String[] args) {
		try {

			// 得到行集并填充数据
			CachedRowSetImpl rowset = new CachedRowSetImpl();
			rowset.setUrl("jdbc:mysql://localhost:3306/test");
			rowset.setUsername("root");
			rowset.setPassword("1234");
			rowset.setCommand("select * from student");
			rowset.setPageSize(4); // 每页行数，一定要在execute()方法执行前设置，否则无效
			rowset.execute();

			System.out.println("从行集中输出数据，第一页：");
			System.out.println("id\tname\tage");
			while (rowset.next()) {
				System.out.print(rowset.getInt(1) + "\t");
				System.out.print(rowset.getString(2) + "\t");
				System.out.print(rowset.getInt(3) + "\n");
			}

			if (rowset.nextPage()) { // 获得后续页数据并输出
				System.out.println("第二页：");
				System.out.println("id\tname\tage");
				while (rowset.next()) {
					System.out.print(rowset.getInt(1) + "\t");
					System.out.print(rowset.getString(2) + "\t");
					System.out.print(rowset.getInt(3) + "\n");
				}
			}

			rowset.close(); // 关闭行集
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}