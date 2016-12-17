package day08;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloJFrame {
	public static void main(String[] args) {
		// 创建JFrame对象
		JFrame jf = new JFrame("hello swing");
		// 设置窗口在关闭时，程序的响应
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(200, 200);// 设置窗口大小
		jf.setVisible(true);// 是否可见
		// 为窗口添加一个标签
		JLabel lable = new JLabel();// 创建JLabel对象
		lable.setText("hello this is one lable");// 设置标签文本
		jf.add(lable);// 把标签添加到Jframe中

	}
}
