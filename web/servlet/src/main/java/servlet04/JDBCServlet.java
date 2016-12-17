package servlet04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver;
	String url;
	String user;
	String password;

	public JDBCServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Connection conn = getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			dispResultSet(rs, out);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		driver = getInitParameter("driver");
		url = getInitParameter("url");
		user = getInitParameter("user");
		password = getInitParameter("password");
	}

	private Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	private void dispResultSet(ResultSet rs, PrintWriter out)
			throws SQLException {
		out.println("<html><head><titl>JDBCServlet</title></head><body>");
		out.println("<p>");
		while (rs.next()) {
			out.println("id:" + rs.getInt(1));
			out.println("name:" + rs.getString(2));
			out.println("age:" + rs.getInt(3));
			out.println("<p>");
		}
		out.println("</body></html>");
		out.flush();
		out.close();
	}
}
