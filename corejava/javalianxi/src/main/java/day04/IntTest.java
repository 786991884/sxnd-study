package day04;

public class IntTest {
	public static void main(String[] args) {
		// 定义int类型的a
		int a = 10;
		// 创建一个integer对象
		Integer b = new Integer(20);
		// 用valueof方法创建一个integer对象
		Integer c = Integer.valueOf(30);
		System.out.println(++a);
		// 转换为int型数据
		System.out.println(b.intValue());
	}
}
