package test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Demo2 {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		ResourceBundle bundle = ResourceBundle.getBundle("message", locale);
		String multi = bundle.getString("multiplication");
		Object[] objs = { 2, 3, 2 * 3 };
		String msg = MessageFormat.format(multi, objs);
		System.out.println(msg);
	}
}
