package com.bean;

import java.util.Set;

public class Factory {

	private Integer factoryId;// 生产商的id

	private String factoryName;// 生产商名称
	private Set<Product> products;// set集合，一个厂商对应的所有图书

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(Integer factoryId) {
		this.factoryId = factoryId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
}
