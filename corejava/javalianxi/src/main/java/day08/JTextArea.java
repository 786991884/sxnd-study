package day08;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class JTextArea {
	public static void main(String[] args) {
		JFrame jf = new JFrame("hello Text");
		jf.setLayout(new FlowLayout());
		// 为窗口添加一个文本域
		// 创建一个5行10列的文本域对象
		javax.swing.JTextArea jta = new javax.swing.JTextArea(5, 10);
		jta.setText("初始化内容");
		jf.add(jta);
		showMe(jf);
	}

	private static void showMe(JFrame jf) {
		// 设置窗口在关闭时，程序的响应
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(200, 200);
		jf.setVisible(true);

	}
}
