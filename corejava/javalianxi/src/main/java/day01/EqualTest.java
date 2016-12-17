package day01;

public class EqualTest {
	public static void main(String[] args) {
		// 定义3个字符串对象
		String a = "1234";
		String b = "1234";
		String c = new String("1234");
		// 3种不同的布尔判定
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(c));
	}
}
