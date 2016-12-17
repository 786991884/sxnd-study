package action;

import java.util.List;
import bean.Book;
import com.opensymphony.xwork2.ActionSupport;

public class BookListAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List books;

	public List getBooks() {
		return books;
	}

	public void setBooks(List books) {
		this.books = books;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}
