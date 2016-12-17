package bookstore.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import bookstore.dao.AccountDao;
import bookstore.dao.BookDao;
import bookstore.dao.TradeDao;
import bookstore.dao.TradeItemDao;
import bookstore.dao.UserDao;
import bookstore.dao.impl.AccountDaoImpl;
import bookstore.dao.impl.BookDaoImpl;
import bookstore.dao.impl.TradeDaoImpl;
import bookstore.dao.impl.TradeItemDaoImpl;
import bookstore.dao.impl.UserDaoImpl;
import bookstore.domain.Book;
import bookstore.domain.ShoppingCart;
import bookstore.domain.ShoppingCartItem;
import bookstore.domain.Trade;
import bookstore.domain.TradeItem;
import bookstore.web.CriteriaBook;
import bookstore.web.Page;

public class BookService {
	private BookDao bookDao = new BookDaoImpl();
	private AccountDao accountDao = new AccountDaoImpl();
	private TradeDao tradeDao = new TradeDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();

	public Page<Book> getPage(CriteriaBook criteriaBook) {
		return bookDao.getPage(criteriaBook);
	}

	public Book getBook(int id) {
		return bookDao.getBook(id);
	}

	public boolean addToCart(int id, ShoppingCart sc) {
		Book book = bookDao.getBook(id);
		if (book != null) {
			sc.addBook(book);
			return true;
		}
		return false;
	}

	public void removeItemFromShoppingCart(ShoppingCart sc, int id) {
		sc.removeItem(id);
	}

	public void clearShoppingCart(ShoppingCart sc) {
		sc.clear();
	}

	public void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
		sc.updateItemQuantity(id, quantity);
	}

	// 业务方法
	public void cash(ShoppingCart shoppingCart, String username,
					 String accountId) {
		// 1.更新mybooks数据表相关记录的salesamount和storeNumber
		bookDao.batchUpdateStoreNumberAndSalesAmount(shoppingCart.getItems());
		// int i=10/0;
		// 2.更新account数据表的balance
		accountDao.updateBalance(Integer.parseInt(accountId),
				shoppingCart.getTotalMoney());
		// 3.向trade数据表插入一条记录
		Trade trade = new Trade();
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		trade.setUserId(userDao.getUser(username).getUserId());
		tradeDao.insert(trade);
		// 4.向tradeItem数据表插入n条记录
		Collection<TradeItem> items = new ArrayList<>();
		for (ShoppingCartItem sci : shoppingCart.getItems()) {
			TradeItem tradeItem = new TradeItem();
			tradeItem.setBookId(sci.getBook().getId());
			tradeItem.setQuantity(sci.getQuantity());
			tradeItem.setTradeId(trade.getTradeId());
			items.add(tradeItem);
		}
		tradeItemDao.batchSave(items);
		// 5.清空购物车
		shoppingCart.clear();
	}
}
