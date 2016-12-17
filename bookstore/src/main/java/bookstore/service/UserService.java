package bookstore.service;

import java.util.Iterator;
import java.util.Set;

import bookstore.dao.BookDao;
import bookstore.dao.TradeDao;
import bookstore.dao.TradeItemDao;
import bookstore.dao.UserDao;
import bookstore.dao.impl.BookDaoImpl;
import bookstore.dao.impl.TradeDaoImpl;
import bookstore.dao.impl.TradeItemDaoImpl;
import bookstore.dao.impl.UserDaoImpl;
import bookstore.domain.Trade;
import bookstore.domain.TradeItem;
import bookstore.domain.User;

public class UserService {
	private UserDao userDao = new UserDaoImpl();
	private TradeDao tradeDao = new TradeDaoImpl();
	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

	public User getUserByUserName(String username) {
		return userDao.getUser(username);
	}

	public User getUserWithTrades(String username) {
		// 调用UserDao的方法获取User对象
		User user = userDao.getUser(username);
		if (user == null) {
			return null;
		}
		// 调用TradeDao的方法获取Trade的集合，把其装配为User的属性
		int userId = user.getUserId();
		// 调用TradeItemDao的方法获取每一个Trade中的TradeItem的集合，并把其装配为Trade的属性
		Set<Trade> trades = tradeDao.getTradesWithUserId(userId);
		if (trades != null) {
			Iterator<Trade> tradeIt = trades.iterator();
			while (tradeIt.hasNext()) {
				Trade trade = tradeIt.next();
				int tradeId = trade.getTradeId();
				Set<TradeItem> items = tradeItemDao
						.getTradeItemWithTradeId(tradeId);
				if (items != null) {
					for (TradeItem item : items) {
						item.setBook(bookDao.getBook(item.getBookId()));
					}
					if (items != null && items.size() != 0) {
						trade.setItems(items);
					}
				}
				if (items == null || items.size() == 0) {
					tradeIt.remove();
				}
			}
		}
		if (trades != null && trades.size() != 0) {
			user.setTrades(trades);
		}
		return user;
	}
}
