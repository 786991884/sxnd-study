package com.xbh.minioa.cfg;

public class Configuration {
	private static int pageSize;
	static {
		// 读取配置default.properties文件，并初始化所有配置
		pageSize = 10;
	}

	public static int getPageSize() {
		return pageSize;
	}
}
