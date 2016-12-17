package com.common;

import java.io.InputStream;
import java.util.Properties;

public class ReadDBPro extends Properties {
	// 读取连接的属性文件
	private static final ReadDBPro dbProp = new ReadDBPro();

	private ReadDBPro() {
		try {
			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream("db.properties");
			load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ReadDBPro getInstance() {
		return dbProp;
	}

	public static String getProp(String key) {
		return dbProp.getProperty(key);
	}

}
