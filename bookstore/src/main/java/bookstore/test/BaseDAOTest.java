package bookstore.test;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import bookstore.dao.impl.BookDaoImpl;
import bookstore.domain.Book;

public class BaseDAOTest {
	private BookDaoImpl bookDao = new BookDaoImpl();

	@Test
	public void testBaseDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		String sql = "INSERT INTO trade(userid,tradetime)VALUES(?,?)";
		long id = bookDao.insert(sql, 1,
				new Date(new java.util.Date().getTime()));
		System.out.println(id);
	}

	@Test
	public void testUpdate() {
		String sql = "UPDATE mybooks SET salesamount = ? WHERE id = ?";
		bookDao.update(sql, 10, 4);
	}

	@Test
	public void testQuery() {
		String sql = "SELECT id, author, title, price, publishingDate, "
				+ "salesAmount, storeNumber, remark FROM mybooks WHERE id = ?";
		Book book = bookDao.query(sql, 4);
		System.out.println(book);
	}

	@Test
	public void testQueryForList() {
		String sql = "SELECT id, author, title, price, publishingDate, "
				+ "salesAmount, storeNumber, remark FROM mybooks WHERE id < ?";

		List<Book> books = bookDao.queryForList(sql, 4);
		System.out.println(books);
	}

	@Test
	public void testGetSingleVel() {
		String sql = "SELECT count(id) FROM mybooks";
		long count = bookDao.getSingleVel(sql);
		System.out.println(count);
	}

	@Test
	public void testBatch() {
		String sql = "UPDATE mybooks SET salesAmount = ?, storeNumber = ? "
				+ "WHERE id = ?";
		bookDao.batch(sql, new Object[] { 1, 1, 1 }, new Object[] { 2, 2, 2 },
				new Object[] { 3, 3, 3 });
	}

}
