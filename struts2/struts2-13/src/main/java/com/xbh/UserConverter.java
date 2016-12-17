package com.xbh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class UserConverter extends StrutsTypeConverter {

	@Override
	// 实现将字符串类型转换成复合类型的方法
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// 创建一个User实例
		User user = new User();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = format1.parse(values[0]);
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
			String birthday = format2.format(date1);
			// 为User实例赋值
			user.setDate(birthday);
			// 返回转换来的User实例
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	// 实现将复合类型转换成字符串类型的方法
	public String convertToString(Map context, Object o) {
		// 将需要转换的值强制类型转换为user实例
		User user = (User) o;
		return "<" + user.getDate() + ">";
	}

}
