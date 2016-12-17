package bookstore.test;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Set;

import org.junit.Test;

import bookstore.dao.TradeDao;
import bookstore.dao.impl.TradeDaoImpl;
import bookstore.domain.Trade;

public class TradeDaoTest {
	private TradeDao tradeDao = new TradeDaoImpl();

	@Test
	public void testInsertTrade() {
		Trade trade = new Trade();
		trade.setUserId(3);
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		tradeDao.insert(trade);
	}

	@Test
	public void testGetTradesWithUserId() {
		Set<Trade> trades = tradeDao.getTradesWithUserId(2);
		System.out.println(trades);
	}

}
