package day01;

public class PrintAge {
	public static void main(String[] args) {
		if (args == null || args.length != 2) {
			return;
		}
		String user = args[0];
		String age = args[1];
		// 打印
		System.out.println("User " + user + "is " + age + "years old");
	}
}
