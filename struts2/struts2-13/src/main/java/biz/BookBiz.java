package biz;

import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookBiz {
	public List<Book> getBooks() {
		// 测试用数据
		List<Book> books = new ArrayList<>();
		books.add(new Book("isbn-111-222-333", "jsp开发", 67, "sun"));
		books.add(new Book("isbn-222-345-987", "Serlvet开发", 66, "sun"));
		books.add(new Book("isbn-453-211-546", "Oracle开发", 67, "oracle"));
		books.add(new Book("isbn-231-758-444", "java开发", 220, "oracle"));
		return books;
	}
}
