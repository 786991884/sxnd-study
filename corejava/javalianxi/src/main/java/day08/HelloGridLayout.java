package day08;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloGridLayout {
	public static void main(String[] args) {
		JFrame jf = new JFrame("GridLayout test");// 创建JFrame对象
		GridLayout grid = new GridLayout(10, 10);
		jf.setLayout(grid);
		for (int i = 0; i < 100; i++) {
			jf.add(new JButton(" " + i));
		}
		jf.setSize(640, 480);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
