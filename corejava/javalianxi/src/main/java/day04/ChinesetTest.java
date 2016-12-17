package day04;

public class ChinesetTest {
	public static void main(String[] args) {
		// 对于英文字母，它们所处的范因是O ～ 127 之间，与ASCII码相同，这是码为Unicode兼容ASCII
		char c = '中';
		int i = c;// 把c变量转换为int型
		System.out.println(i);// 打印出'中'所对应的整形值为多少
	}
}
