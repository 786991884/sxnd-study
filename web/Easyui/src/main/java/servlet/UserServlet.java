package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;
import model.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import dao.UserDao;
import dao.impl.UserDaoImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// servlet是原型模式
	private UserDao udao = new UserDaoImpl();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("getCity".equals(method)) {
			getCity(request, response);
		} else if ("save".equals(method)) {
			save(request, response);
		} else if ("getList".equals(method)) {
			getList(request, response);
		} else if ("getCityName".endsWith(method)) {
			getCityName(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("searchName".equals(method)) {
			searchName(request, response);
		}
	}

	/**
	 * 获取城市数据
	 *
	 * @param request
	 * @param response
	 */
	private void getCity(HttpServletRequest request,
						 HttpServletResponse response) {
		try {
			List<City> clist = new ArrayList<City>();
			clist.add(new City(1, "北京"));
			clist.add(new City(2, "上海"));
			clist.add(new City(3, "深圳"));
			clist.add(new City(4, "长春"));
			response.setContentType("text/html;charset=utf-8");
			String str = JSONArray.fromObject(clist).toString();
			response.getWriter().write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户保存方法
	 *
	 * @param request
	 * @param response
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String birthday = request.getParameter("birthday");
			int city = Integer.parseInt(request.getParameter("city"));
			String salary = request.getParameter("salary");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String description = request.getParameter("description");
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setSex(sex);
			user.setAge(age);
			user.setBirthday(birthday);
			user.setCity(city);
			user.setSalary(salary);
			user.setStartTime(startTime);
			user.setEndTime(endTime);
			user.setDescription(description);
			this.udao.save(user);
			response.setContentType("text/html;charset=utf-8");
			// {"status":"ok" , "message":"操作成功"}
			String str = "{\"status\":\"ok\",\"message\":\"操作成功！\"}";
			response.getWriter().write(str);
		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			// {"status":"fail" , "message":"操作失败!"}
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			e.printStackTrace();
		}
	}

	/**
	 * 获取用户列表信息
	 *
	 * @param request
	 * @param response
	 */
	private void getList(HttpServletRequest request,
						 HttpServletResponse response) {
		try {
			int currentPage = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("rows"));
			String username = request.getParameter("username") == null ? ""
					: request.getParameter("username");
			String startTime = request.getParameter("startTime") == null ? ""
					: request.getParameter("startTime");
			String endTime = request.getParameter("endTime") == null ? ""
					: request.getParameter("endTime");
			String order = request.getParameter("order") == null ? "" : request
					.getParameter("order");
			String sort = request.getParameter("sort") == null ? "" : request
					.getParameter("sort");

			Map<String, Object> m = new HashMap<String, Object>();
			m.put("username", username);
			m.put("startTime", startTime);
			m.put("endTime", endTime);
			m.put("order", order);
			m.put("sort", sort);
			// List<User> ulist = this.udao.findAll();
			List<User> ulist = this.udao.findByPagination(currentPage,
					pageSize, m);
			int total = this.udao.getTotal();
			response.setContentType("text/html;charset=utf-8");
			// {"total":10,"rows":[{},{},{}]}
			String json = "{\"total\":" + total + ",\"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据城市id获取指定城市对象
	 *
	 * @param request
	 * @param response
	 */
	private void getCityName(HttpServletRequest request,
							 HttpServletResponse response) {
		try {
			List<City> clist = new ArrayList<City>();
			clist.add(new City(1, "北京"));
			clist.add(new City(2, "上海"));
			clist.add(new City(3, "深圳"));
			clist.add(new City(4, "长春"));
			int id = Integer.parseInt(request.getParameter("id"));
			for (Iterator iterator = clist.iterator(); iterator.hasNext();) {
				City city = (City) iterator.next();
				if (city.getId() == id) {
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().write(
							JSONObject.fromObject(city).toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 修改用户方法
	 *
	 * @param request
	 * @param response
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = this.udao.findById(id);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String birthday = request.getParameter("birthday");
			int city = Integer.parseInt(request.getParameter("city"));
			String salary = request.getParameter("salary");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String description = request.getParameter("description");
			user.setUsername(username);
			user.setPassword(password);
			user.setSex(sex);
			user.setAge(age);
			user.setBirthday(birthday);
			user.setCity(city);
			user.setSalary(salary);
			user.setStartTime(startTime);
			user.setEndTime(endTime);
			user.setDescription(description);
			this.udao.update(user);
			response.setContentType("text/html;charset=utf-8");
			// {"status":"ok" , "message":"操作成功"}
			String str = "{\"status\":\"ok\",\"message\":\"操作成功！\"}";
			response.getWriter().write(str);
		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			// {"status":"fail" , "message":"操作失败!"}
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			e.printStackTrace();
		}
	}

	/**
	 * 删除用户方法
	 *
	 * @param request
	 * @param response
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String[] ids = request.getParameter("ids").split(",");
			for (int i = 0; i < ids.length; i++) {
				this.udao.delete(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 自动搜索的方法
	 *
	 * @param request
	 * @param response
	 */
	private void searchName(HttpServletRequest request,
							HttpServletResponse response) {
		try {
			String q = request.getParameter("q") == null ? "" : request
					.getParameter("q");
			List<User> ulist = this.udao.searchByName(q.trim());
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(JSONArray.fromObject(ulist).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		List<City> clist = new ArrayList<City>();
		clist.add(new City(1, "北京"));
		clist.add(new City(2, "上海"));
		clist.add(new City(3, "深圳"));
		clist.add(new City(4, "长春"));
		// System.out.println(JSONArray.fromObject(clist).toString());
	}
}