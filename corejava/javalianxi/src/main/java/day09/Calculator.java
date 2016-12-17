package day09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	public static void main(String[] args) {
		CalFrame calculator = new CalFrame();
		calculator.show();// 打开程序
	}
}

// 窗口类
class CalFrame implements ActionListener {
	private JFrame mainFrame;// 窗口对象
	private JTextField text;// 文本框
	private JButton[] buttons;// 按钮框
	private char modifier = '\0';// 运算符
	private double result;// 运算结果
	private boolean flag = false;// 标记，是否单击了运算符按钮

	public CalFrame() {// 构造方法
		// 构造必要组件
		mainFrame = new JFrame("计算器v1.0");
		text = new JTextField();
		buttons = new JButton[16];
		init();
		setFontAndColor();
		addEventHandle();
	}

	private void init() {
		JPanel north = new JPanel();
		JPanel center = new JPanel();
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(4, 4, 2, 2));// 布局
		text = new JTextField(25);
		north.add(text);
		// 用字符串表示所有按钮的字符
		String str = "123+456-789*0.=/";
		for (int i = 0; i < 16; i++) {
			JButton jb = new JButton(String.valueOf(str.charAt(i)));
			buttons[i] = jb;
			center.add(jb);
		}
		mainFrame.add(north, BorderLayout.NORTH);
		mainFrame.add(center, BorderLayout.CENTER);
	}

	// 显示窗口
	public void show() {
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// 设置字体和颜色
	private void setFontAndColor() {
		Font f = new Font("黑体", Font.BOLD, 20);
		text.setFont(f);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setFont(f);
			buttons[i].setForeground(Color.RED);
		}
	}

	public void addEventHandle() {
		for (int i = 0; i < buttons.length; i++) {
			// 为每个按钮添加监听器对象
			buttons[i].addActionListener(this);
		}
	}

	@Override
	// 本类实现ActionListener接口，即可访问本对象的全部属性
	public void actionPerformed(ActionEvent e) {
		// 获得按钮上的文本
		String str = e.getActionCommand();
		// 输入是数字
		if ("0123456789.".indexOf(str) != -1) {
			// 如果已经单击了数字按钮
			if (flag) {
				text.setText("");
				flag = false;
			}
			text.setText(text.getText() + str);
		} else if ("+-*/".indexOf(str) != -1) {
			modifier = str.charAt(0);
			double num = Double.valueOf(text.getText());
			result = num;
			flag = true;
		} else if (str.charAt(0) == '=') {
			if (modifier == '+') {
				double num = Double.valueOf(text.getText());
				result += num;
			}
			if (modifier == '-') {
				double num = Double.valueOf(text.getText());
				result -= num;
			}
			if (modifier == '*') {
				double num = Double.valueOf(text.getText());
				result *= num;
			}
			if (modifier == '/') {
				double num = Double.valueOf(text.getText());
				result /= num;
			}
			text.setText(result + "");
			modifier = '\0';
			result = 0;
		}
	}
}