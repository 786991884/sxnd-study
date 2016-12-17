package day05;

public class StringBBTest {
	public static void main(String[] args) {
		// 效率低下
		// String a = "a";
		// String b = "b";
		// String c = "c";
		// String d = "d";
		// String abcd = a + b + c + d;
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		StringBuffer sb = new StringBuffer();// 创建StringBuffer对象
		sb.append(a);// 用append方法追加字符串
		sb.append(b);
		sb.append(c);
		sb.append(d);
		String abcd = sb.toString();// 用toString方法得到sb的值
		System.out.println(abcd);
		// 如果加涉及线程安全的问题，应用使用StringBuilder
	}
}
