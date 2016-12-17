package com.Admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.dao.AdminUserDao;
import com.Admin.daoimpl.AdminUserDaoImpl;
import com.Admin.vo.MerchantPager;

/**
 * Servlet implementation class GetMerchantPagerServlet
 */
@WebServlet("/getMerchantPagerServlet")
public class GetMerchantPagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetMerchantPagerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pagerOffset = request.getParameter("pager.offset");
		String pageSize_str = request.getParameter("pageSize");
		int offset = 0;
		int pagecurrentPageNo = 1;
		int pageSize = 5;
		if (pagerOffset != null && pageSize_str != null) {
			offset = Integer.parseInt(pagerOffset);
			pageSize = Integer.parseInt(pageSize_str);
		}
		AdminUserDao adminUserDao = new AdminUserDaoImpl();
		MerchantPager mp = adminUserDao.getMerchentPager(offset, pageSize);
		if (mp.getMerchantMap().size() == 0 && offset != 0) {
			offset -= pageSize;
			mp = adminUserDao.getMerchentPager(offset, pageSize);
		}
		if (offset % pageSize == 0 || offset / pageSize > 0) {
			pagecurrentPageNo = offset / pageSize + 1;
		}
		mp.setPagecurrentPageNo(pagecurrentPageNo);
		mp.setPageOffset(offset);
		request.getSession().setAttribute("merchantPager", mp);
		request.getSession().setAttribute("merchantList",
				mp.getMerchantMap().values());
		request.getRequestDispatcher("Admin/pages/manageMerchants.jsp")
				.forward(request, response);
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
