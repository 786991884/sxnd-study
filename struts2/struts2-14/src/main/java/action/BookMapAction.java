package action;

import java.util.Map;

import bean.Book;

import com.opensymphony.xwork2.ActionSupport;

public class BookMapAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Map<String, Book> books;

	public Map<String, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
