package com.Admin.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Admin.vo.Merchant;
import com.Admin.vo.MerchantPager;

/**
 * Servlet implementation class GetOneMerchantServlet
 */
@WebServlet("/getOneMerchantServlet")
public class GetOneMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOneMerchantServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id_str = request.getParameter("id");
		int id = 0;
		if (id_str != null) {
			id = Integer.parseInt(id_str);
		}
		MerchantPager merchantPager = (MerchantPager) request.getSession()
				.getAttribute("merchantPager");
		Map merchantMap = merchantPager.getMerchantMap();
		Merchant merchant = (Merchant) merchantMap.get(id);
		request.setAttribute("merchant", merchant);
		request.getRequestDispatcher("Admin/pages/manageDetailMerchant.jsp")
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
