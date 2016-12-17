package tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ZoneServlet
 */
@WebServlet("/ZoneServlet")
public class ZoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ZoneServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // 获取action参数的值
		if ("getProvince".equals(action)) { // 获取省份和直辖市信息
			this.getProvince(request, response);
		} else if ("getCity".equals(action)) { // 获取市县信息
			this.getCity(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 获取省份和直辖市
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getProvince(HttpServletRequest request,
							HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); // 设置响应的编码方式
		String result = "";
		CityMap cityMap = new CityMap();// 实例化保存省份信息的CityMap类的实例
		Map<String, String[]> map = cityMap.model;// 获取省份信息保存到Map中
		Set<String> set = map.keySet(); // 获取Map集合中的键，并以Set集合返回
		Iterator it = set.iterator();
		while (it.hasNext()) { // 将获取的省份连接为一个以逗号分隔的字符串
			result = result + it.next() + ",";
		}
		result = result.substring(0, result.length() - 1); // 去除最后一个逗号
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的省份字符串
		out.flush();
		out.close();
	}

	/**
	 * 获取市县
	 *
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCity(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); // 设置响应的编码方式
		String result = "";
		String selProvince = request.getParameter("parProvince"); // 获取选择的省份
		selProvince = new String(selProvince.getBytes("ISO-8859-1"), "utf-8");
		CityMap cityMap = new CityMap(); // 实例化保存省份信息的CityMap类的实例
		Map<String, String[]> map = cityMap.model; // 获取省份信息保存到Map中
		String[] arrCity = map.get(selProvince); // 获取指定键的值
		for (int i = 0; i < arrCity.length; i++) { // 将获取的市县连接为一个以逗号分隔的字符串
			result = result + arrCity[i] + ",";
		}
		result = result.substring(0, result.length() - 1); // 去除最后一个逗号
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(result); // 输出获取的市县字符串
		out.flush();
		out.close();
	}

}
