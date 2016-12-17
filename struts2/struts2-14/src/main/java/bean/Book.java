package bean;

public class Book {
	private String title;
	private float price;
	private String publisher;

	public Book() {
	}

	public Book(String title, float price, String publisher) {
		super();
		this.title = title;
		this.price = price;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return getTitle() + "," + getPrice() + "," + getPublisher();
	}
}
