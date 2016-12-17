package bookstore.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;

import bookstore.dao.TradeItemDao;
import bookstore.dao.impl.TradeItemDaoImpl;
import bookstore.domain.TradeItem;

public class TradeItemDaoTest {
	private TradeItemDao tradeItemDao = new TradeItemDaoImpl();

	@Test
	public void testBatchSave() {
		Collection<TradeItem> items = new ArrayList<>();
		items.add(new TradeItem(null, 1, 10, 25));
		items.add(new TradeItem(null, 2, 20, 25));
		items.add(new TradeItem(null, 3, 30, 25));
		items.add(new TradeItem(null, 4, 40, 25));
		items.add(new TradeItem(null, 5, 50, 25));
		tradeItemDao.batchSave(items);
	}

	@Test
	public void testGetTradeItemWithTradeId() {
		Set<TradeItem> items = tradeItemDao.getTradeItemWithTradeId(25);
		System.out.println(items);
	}

}
