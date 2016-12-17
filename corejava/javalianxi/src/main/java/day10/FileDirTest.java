package day10;

import java.io.File;
import java.io.IOException;

public class FileDirTest {
	public static void main(String[] args) {
		// 创建文件对象file1
		File file1 = new File("D:/test/a.txt");
		// 判断它是否已经存在
		if (!file1.exists()) {
			try {
				file1.createNewFile();// 创建新文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 创建dir目录对象
		File dir = new File("D:/test");
		if (dir.isDirectory()) {// 判断它是否为主目录
			// 调用list方法获取它的所有文件
			String[] files = dir.list();
			// 对文件进行遍历
			for (String fileName : files) {
				// 用目录和文件名生成File对象
				File f = new File(dir.getPath() + File.separator + fileName);
				// 进行分类打印
				if (f.isFile()) {
					System.out.println("file:" + f.getName());
				} else {
					System.out.println("dir:" + f.getName());
				}
			}
		}
	}
}
