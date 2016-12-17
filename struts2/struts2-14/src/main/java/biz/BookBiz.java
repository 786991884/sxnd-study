package biz;

import java.util.ArrayList;
import java.util.List;

import bean.Book9;

public class BookBiz {
	public List<Book9> getBooks() {
		List<Book9> bookList = new ArrayList<Book9>();
		bookList.add(new Book9("corejava", "jdk7"));
		bookList.add(new Book9("html/css", "html5"));
		bookList.add(new Book9("servlet", "servlet3.0"));
		bookList.add(new Book9("struts", "struts2.2.1"));
		return bookList;
	}
}
