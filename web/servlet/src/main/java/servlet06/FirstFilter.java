package servlet06;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class FirstFilter implements Filter {
	private FilterConfig filterConfig;

	public FirstFilter() {
	}

	public void destroy() {
		System.out.println("Filter销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = filterConfig.getInitParameter("name");
		String str = filterConfig.getInitParameter("doST");
		System.out.println(new String(name.getBytes("iso-8859-1"), "utf-8")
				+ ":" + str);
		request.setAttribute("name", name);
		request.setAttribute("str", str);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
		System.out.println("filter 初始化 Init");
	}

}
