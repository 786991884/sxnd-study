package com.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bean.Admin;

public class Manger7 extends AbstractController {
	private Admin admin;// 注入admin对象

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	// 登录验证
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
												 HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");// 用户名
		String password = request.getParameter("password");// 密码
		// 验证用户输入的用户名和密码
		if (name.equals(admin.getName())
				&& password.equals(admin.getPassword())) {
			return new ModelAndView("succ");// 跳转到登录成功页面
		} else {
			return new ModelAndView("error");// 跳转到登录失败页面
		}
	}
}
