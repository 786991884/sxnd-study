package entity;

public class OrderDetail {
	private String id;
	private Order order;
	private Product product;
	private int count;
	private double money;

	public OrderDetail() {
	}

	public OrderDetail(String id, Order order, Product product, int count,
			double money) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.count = count;
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}
