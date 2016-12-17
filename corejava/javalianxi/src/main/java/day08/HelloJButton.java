package day08;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloJButton {
	public static void main(String[] args) {
		JFrame jf = new JFrame("hello swing");
		// 设置窗口在关闭时，程序的响应
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(200, 200);
		jf.setVisible(true);
		// 设置布局格式
		jf.setLayout(new FlowLayout());
		// 为窗口添加一个按钮
		JButton btn = new JButton("my button");
		jf.add(btn);
	}
}
