package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtils;
import dao.ProdDao;
import entity.Product;

public class ProdDaoImpl implements ProdDao {
	Connection conn = null;
	PreparedStatement pt = null;
	ResultSet rs = null;

	@Override
	public List getAllProd() {
		List prodList = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from product order by putawaytime desc";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProdid(rs.getString("prodid"));
				product.setProdname(rs.getString("prodname"));
				product.setPutawaytime(rs.getDate("putawaytime"));
				product.setIsspecial(rs.getString("isspecial"));
				product.setIsfashion(rs.getString("isfashion"));
				product.setProdprice(rs.getDouble("prodprice"));
				product.setProdimg(rs.getString("prodimg"));
				product.setProdtype(rs.getString("prodtype"));
				prodList.add(product);
			}
			return prodList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return null;
	}

	@Override
	public Product getProductById(String prodId) {
		Product product = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from product where prodId=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, prodId);
			rs = pt.executeQuery();
			while (rs.next()) {
				product = new Product();
				product.setProdid(rs.getString("prodid"));
				product.setProdname(rs.getString("prodname"));
				product.setPutawaytime(rs.getDate("putawaytime"));
				product.setIsspecial(rs.getString("isspecial"));
				product.setIsfashion(rs.getString("isfashion"));
				product.setProdprice(rs.getDouble("prodprice"));
				product.setProdimg(rs.getString("prodimg"));
				product.setProdtype(rs.getString("prodtype"));
			}
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.free(rs, pt, conn);
		}
		return null;
	}

	@Override
	public List getProductByType(String prodType) {
		List prodList = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from product where prodtype='" + prodType
					+ "'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProdid(rs.getString("prodid"));
				product.setProdname(rs.getString("prodname"));
				product.setPutawaytime(rs.getDate("putawaytime"));
				product.setIsspecial(rs.getString("isspecial"));
				product.setIsfashion(rs.getString("isfashion"));
				product.setProdprice(rs.getDouble("prodprice"));
				product.setProdimg(rs.getString("prodimg"));
				product.setProdtype(rs.getString("prodtype"));
				prodList.add(product);
			}
			return prodList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
