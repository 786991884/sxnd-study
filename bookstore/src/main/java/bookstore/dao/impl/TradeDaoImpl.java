package bookstore.dao.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import bookstore.dao.TradeDao;
import bookstore.domain.Trade;

public class TradeDaoImpl extends BaseDao<Trade> implements TradeDao {

	@Override
	public void insert(Trade trade) {
		String sql = "INSERT INTO trade(userid,tradetime) VALUES(?,?)";
		long tradeId = insert(sql, trade.getUserId());
		trade.setTradeId((int) tradeId);

	}

	@Override
	public Set<Trade> getTradesWithUserId(Integer userId) {
		String sql = "SELECT tradeId,userId,tradeTime FROM trade WHERE userId=? ORDER BY tradeTime DESC";
		return new LinkedHashSet(queryForList(sql, userId));
	}

}
