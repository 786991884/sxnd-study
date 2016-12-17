package day08;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloBorderLayout {
	public static void main(String[] args) {
		JFrame jf = new JFrame("BorderLayout test");
		jf.setLayout(new BorderLayout());
		jf.add(new JButton("east"), BorderLayout.EAST);// 东部
		jf.add(new JButton("center"), BorderLayout.CENTER);// 中间
		jf.add(new JButton("south"), BorderLayout.SOUTH);// 南部
		jf.add(new JButton("north"), BorderLayout.NORTH);// 北部
		jf.add(new JButton("west"), BorderLayout.WEST);// 西部
		// 分别代表长度和高度
		jf.setSize(300, 200);
		jf.setVisible(true);
		// 默认为隐藏而不停止程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
