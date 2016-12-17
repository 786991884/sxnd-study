package day08;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class HelloJTextField {
	public static void main(String[] args) {
		JFrame jf = new JFrame("hello Text");
		// 设置布局格式
		jf.setLayout(new FlowLayout());
		// 为窗口添加一个文本框
		JTextField jtf = new JTextField(10);
		// 设置初始文本内容
		jtf.setText("初始化内容");
		jf.add(jtf);
		showMe(jf);

	}

	private static void showMe(JFrame jf) {
		// 设置窗口在关闭时，程序的响应
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(200, 200);
		jf.setVisible(true);

	}
}
