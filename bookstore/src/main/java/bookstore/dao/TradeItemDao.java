package bookstore.dao;

import java.util.Collection;
import java.util.Set;

import bookstore.domain.TradeItem;

public interface TradeItemDao {
	/**
	 * 批量保存TradeItem对象
	 *
	 * @param items
	 */
	void batchSave(Collection<TradeItem> items);

	/**
	 * 根据tradeId获取和其关联的TradeItem的集合
	 *
	 * @param tradeId
	 * @return
	 */
	Set<TradeItem> getTradeItemWithTradeId(Integer tradeId);
}
