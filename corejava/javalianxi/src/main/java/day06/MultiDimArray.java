package day06;

public class MultiDimArray {
	public static void main(String[] args) {
		// 定义数组
		int[][] arr = new int[3][];
		arr[0] = new int[] { 4 };
		arr[1] = new int[] { 4, 5 };
		arr[2] = new int[] { 4, 5, 6 };
		// 逐个访问数组
		for (int[] a : arr) {
			for (int i : a) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
