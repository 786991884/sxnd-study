package day06;

public class ArrayCopy {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3 };
		int[] arr2 = arr;// 赋值引用
		arr2[2] = 7;// 改变一个元素的值
		for (int i : arr) {
			System.out.println(i);
		}
		int[] arr3 = new int[3];
		// 深拷贝数组
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		arr3[2] = 5;
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
