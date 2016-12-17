package biz.impl;

import java.util.ArrayList;
import java.util.List;

import biz.ProdService;
import dao.ProdDao;
import dao.impl.ProdDaoImpl;
import entity.Product;

public class ProdServiceImpl implements ProdService {

	/**
	 * 根据产品Id得到产品信息
	 * 
	 * @param prodId
	 * @return
	 */
	public Product getProductById(String prodId) {
		ProdDao prodDao = new ProdDaoImpl();
		Product product =prodDao.getProductById(prodId);
		return product;
	}

	/**
	 * 根据产品类型得到产品列表
	 * 
	 * @param prodType
	 * @return
	 */
	public List getProdByType(String prodType) {
		ProdDao prodDao = new ProdDaoImpl();
		List prodList = new ArrayList();
		prodList = prodDao.getProductByType(prodType);
		return prodList;
	}

	/**
	 * 得到所有商品
	 * 
	 * @return
	 */
	public List getAllProd() {
		ProdDao prodDao = new ProdDaoImpl();
		List prodList = new ArrayList();
		prodList = prodDao.getAllProd();
		return prodList;
	}
}
