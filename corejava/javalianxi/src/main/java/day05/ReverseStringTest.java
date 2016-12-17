package day05;

public class ReverseStringTest {
	public static void main(String[] args) {
		// 原始字符串
		String s = "A quick brown fox jumps over the lazy dog.";
		System.out.println("原始的字符串：" + s);
		System.out.print("反转后的字符串：");
		for (int i = s.length(); i > 0; i--) {
			System.out.print(s.charAt(i - 1));// 反循环打印
		}
		// 也可以转换成数组后再反转，不过有点多此一举
		char[] data = s.toCharArray();// 得到char数组
		System.out.println();
		System.out.print("反转后字符串：");
		for (int i = data.length; i > 0; i--) {
			System.out.print(data[i - 1]);// 依次打印
		}
		System.out.println();
		// 用StringBuffer类的reverse()方法可以将字符串反转
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb.reverse().toString());
	}
}
