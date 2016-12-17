package day02;

public class Max {
	public static void main(String[] args) {
		int a = 5;
		int b = 8;
		// 三元运算符
		String rst = a > b ? "a bigger than b" : "b bigger than a";
		System.out.println(rst);
		String result = null;
		if (a > b) {
			result = "a bigger than b";
		} else {
			result = "b bigger than a";
		}
	}
}
