package day08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class HelloEvent {
	// 创建一个文本框对象
	private static JTextField text = new JTextField(10);

	public static void main(String[] args) {
		JFrame jf = new JFrame("Hello Text");
		jf.setLayout(new FlowLayout());
		// 为窗口添加一个文本框
		jf.add(text);
		// 为窗口添加一个按钮
		JButton btn = new JButton("my button");
		jf.add(btn);// 添加事件到窗口中
		btn.addActionListener(new ActionListener() {// 添加事件
			// 定义事件回调方法
			@Override
			public void actionPerformed(ActionEvent e) {
				HelloEvent.text.setText("按钮被点击了");// 动作
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
