package day08;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloFlowLayout {
	public static void main(String[] args) {
		JFrame jf = new JFrame("hello flowlayout");
		// 设置布局管理器
		jf.setLayout(new FlowLayout());
		for (int i = 0; i < 10; i++) {
			// 添加10个按钮
			jf.add(new JButton(i + " "));
		}
		jf.setSize(640, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
