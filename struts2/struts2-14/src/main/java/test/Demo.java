package test;

import java.util.Locale;
import java.util.ResourceBundle;

public class Demo {
	public static void main(String[] args) {
		// 创建应用于中国的Local
		Locale locale_zh = new Locale("zh", "CN");
		// 创建应用于美国的Local
		Locale locale_en = new Locale("en", "US");
		// 获取当前操作系统的Local
		Locale locale = Locale.getDefault();
		System.out.println(locale_zh);
		// 获得系统默认的国家/语言环境
		// 根据指定国家/语言环境加载资源文件
		ResourceBundle bundle = ResourceBundle.getBundle("message", locale);
		// 打印从资源文件中获取到的内容
		System.out.println(bundle.getString("sayHello"));
	}
}
