package ch08.estore;

import java.util.HashMap;
import java.util.Map;

public class BookStore {
	private Map<String, Book> books = new HashMap<String, Book>();

	public Map<String, Book> getBooks() {
		books.put("1", new Book("1", "红楼梦", 50.59));
		books.put("2", new Book("2", "三国志", 60.00));
		books.put("4", new Book("4", "西游记", 70.00));
		books.put("5", new Book("5", "水浒传", 88.00));
		books.put("7", new Book("7", "三国演义", 160.00));
		return books;
	}

	public Book getBook(String id) {
		return books.get(id);
	}
}
