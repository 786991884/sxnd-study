package day04;

public class CharTest {
	public static void main(String[] args) {
		char c = 'a';// 定义char型的a变量
		short s = (short) c;// 把a转换成short型的s变量
		System.out.println((char) s);// 再把short转换成char进行打印
	}
}
