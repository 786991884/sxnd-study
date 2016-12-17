package dao;

import java.util.List;

import entity.Product;

public interface ProdDao {

	List getAllProd();

	Product getProductById(String prodId);

	List getProductByType(String prodType);

}
