package bookstore.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import bookstore.dao.BookDao;
import bookstore.dao.impl.BookDaoImpl;
import bookstore.db.JDBCUtils;
import bookstore.domain.Book;
import bookstore.domain.ShoppingCartItem;
import bookstore.web.ConnectionContext;
import bookstore.web.CriteriaBook;
import bookstore.web.Page;

public class BookDaoTest {
	private BookDao bookDao = new BookDaoImpl();

	@Test
	public void testGetBook() {
		Connection connection = JDBCUtils.getConnection();
		ConnectionContext.getInstance().bind(connection);
		Book book = bookDao.getBook(5);
		System.out.println(book);
	}

	@Test
	public void testGetPage() {
		CriteriaBook cb = new CriteriaBook(50, 60, 90);
		Page<Book> page = bookDao.getPage(cb);
		System.out.println("pageNo:" + page.getPageNo());
		System.out.println("totalPageNumber: " + page.getTotalPageNumber());
		System.out.println("list: " + page.getList());
		System.out.println("prevPage: " + page.getPrevPage());
		System.out.println("nextPage: " + page.getNextPage());
	}

	@Test
	public void testGetTotalBookNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStoreNumber() {
		int storeNumber = bookDao.getStoreNumber(5);
		System.out.println(storeNumber);
	}

	@Test
	public void testBatchUpdateStoreNumberAndSalesAmount() {
		Collection<ShoppingCartItem> items = new ArrayList<>();
		Book book = bookDao.getBook(1);
		ShoppingCartItem sci = new ShoppingCartItem(book);
		sci.setQuantity(10);
		items.add(sci);
		book = bookDao.getBook(2);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(11);
		items.add(sci);

		book = bookDao.getBook(3);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(12);
		items.add(sci);

		book = bookDao.getBook(4);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(14);
		items.add(sci);

		bookDao.batchUpdateStoreNumberAndSalesAmount(items);
	}

}
