package day02;

public class Test1 {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
		int i = 1;
		while (i <= 100) {
			System.out.println(i);
			i++;
		}
		do {
			System.out.println(i++);
		} while (i < 100);
	}
}
