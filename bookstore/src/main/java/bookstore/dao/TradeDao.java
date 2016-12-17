package bookstore.dao;

import java.util.Set;

import bookstore.domain.Trade;

public interface TradeDao {
	/**
	 * 向数据表中插入Trade对象
	 *
	 * @param
	 */
	void insert(Trade trade);

	/**
	 * 根据userId获取和其关联的Trade的集合
	 *
	 * @param userId
	 * @return
	 */
	Set<Trade> getTradesWithUserId(Integer userId);
}
