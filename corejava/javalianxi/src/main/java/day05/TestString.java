package day05;

import java.io.UnsupportedEncodingException;

public class TestString {
	public static void main(String[] args) {
		String a = "中文";
		System.out.println(a);
		String b = new String("中文");
		System.out.println(b);
		try {
			String c = new String(a.getBytes(), "GBK");
			String d = new String(a.getBytes(), "utf-8");
			System.out.println(c + "," + d);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
