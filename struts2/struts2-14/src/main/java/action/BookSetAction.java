package action;

import java.util.HashSet;
import java.util.Set;

import bean.Book;

import com.opensymphony.xwork2.ActionSupport;

public class BookSetAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	// 需要手动实例化该对象，框架不会自动实例化该对象
	private Set<Book> books = new HashSet<>();

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Book> getBooks() {
		return books;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
