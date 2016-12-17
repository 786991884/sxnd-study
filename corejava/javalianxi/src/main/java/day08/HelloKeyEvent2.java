package day08;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class HelloKeyEvent2 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("hello events");
		jf.setLayout(new FlowLayout());
		// 创建文本框输入对象
		JTextField jtf = new JTextField(15);
		jf.add(jtf);
		jtf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar() + " pressed");

			}
		});
		showMe(jf);
	}

	private static void showMe(JFrame jf) {
		// 设置窗口在关闭时，程序的响应
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(200, 200);
		jf.setVisible(true);

	}
}
