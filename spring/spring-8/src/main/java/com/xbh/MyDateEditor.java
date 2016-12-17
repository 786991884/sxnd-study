package com.xbh;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class MyDateEditor extends PropertyEditorSupport {
	// 设置日期格式方法
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Date date = new Date(text);
		setValue(date);// 设置日期格式
	}
}
