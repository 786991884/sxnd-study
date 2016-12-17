package com.oraclewdp.jstldemo;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.TimeZone;

public class msg_zh extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] { { "login.name", "李四" },
				{ "login.time", "1919-3-3" } };
	}

	public static void main(String[] args) {
		System.out.println(Locale.getDefault());
		System.out.println(TimeZone.getDefault());
	}

}
