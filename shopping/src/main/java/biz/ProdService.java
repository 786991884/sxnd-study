package biz;

import java.util.List;

import entity.Product;

public interface ProdService {

	// 根据产品Id得到产品信息
	public Product getProductById(String prodId);

	// 根据产品类型得到产品列表
	public List getProdByType(String prodType);

	// 得到所有商品
	public List getAllProd();
}
