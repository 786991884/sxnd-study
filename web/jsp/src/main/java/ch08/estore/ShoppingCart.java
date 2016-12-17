package ch08.estore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	// String类型的key就是商品的id
	Map<String, SalesLine> salesLines = new HashMap<String, SalesLine>();

	public void addLine(SalesLine line) {

	}

	public void dropLine(SalesLine line) {

	}

	public Collection list() {
		return salesLines.values();
	}

	public double cost() {
		return 0;
	}

	public void removeAll() {

	}
}
