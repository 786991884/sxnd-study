package com.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class MyFriendsServlet
 */
@WebServlet("/MyFriendsServlet")
public class MyFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyFriendsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		JSONArray arrJson = new JSONArray();
		JSONObject objJson = new JSONObject();
		objJson.put("name", "马云");
		objJson.put("img", "Admin/images/monkey.jpg");
		objJson.put("desc", "我大愚若智，其实很笨");
		arrJson.add(objJson);
		objJson = new JSONObject();
		objJson.put("name", "马化腾");
		objJson.put("img", "Admin/images/qq.jpg");
		objJson.put("desc", "成功=百分之99的抄袭+百分之1的改造");
		arrJson.add(objJson);
		objJson = new JSONObject();
		objJson.put("name", "埃里森");
		objJson.put("img", "Admin/images/pan.jpg");
		objJson.put("desc", "读了三个大学，没得到...");
		arrJson.add(objJson);
		objJson = new JSONObject();
		objJson.put("name", "比尔盖茨");
		objJson.put("img", "Admin/images/pan.jpg");
		objJson.put("desc", "有非凡志向，才有非凡成就");
		arrJson.add(objJson);
		objJson = new JSONObject();
		objJson.put("name", "奥巴马");
		objJson.put("img", "Admin/images/head.jpg");
		objJson.put("desc", "钓鱼岛是中国的...");
		arrJson.add(objJson);
		out.print(arrJson.toString());
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
