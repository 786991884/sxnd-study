package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtils;
import dao.NoticeDao;
import entity.Customer;
import entity.Notice;

public class NoticeDaoImpl implements NoticeDao {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	// 得到所有广告
	@Override
	public List getNotice() {
		List noticeList = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from notice ";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setId(rs.getString("id"));
				notice.setMessage(rs.getString("message"));
				noticeList.add(notice);
			}
			return noticeList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return null;
	}

}
