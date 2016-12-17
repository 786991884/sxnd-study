package day06;

public class ArrarClass {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };// 定义一个int数组变量
		String[] arr2 = new String[3];// 定义一个String数组变量
		for (int i : arr) {// 循环打印arr的值
			System.out.println(i);
		}
		for (String i : arr2) {// 循环打印arr2的值
			System.out.println(i);
		}
		System.out.println("int arr type name:" + arr.getClass().getName());
		System.out.println("String arr type name:" + arr2.getClass().getName());
		// 引用类型的数组
		Object[] objArr = new Object[] { new Object(), null, new String("abc") };
		// 数组元素再赋对象引用
		objArr[0] = new Object();
		objArr[2] = new String("abc");// 数组元素再赋字符对象引用
		for (Object obj : objArr) {
			System.out.print(obj + " ");
		}

	}
}
