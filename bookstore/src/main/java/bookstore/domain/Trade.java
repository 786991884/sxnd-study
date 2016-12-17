package bookstore.domain;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {
	// Trade对象对应的id
	private Integer tradeId;
	// 交易的时间
	private Date tradeTime;
	// Trade关联的多个TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();
	// 和Trade关联的User的userId
	private Integer userId;

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime
				+ ", items=" + items + ", userId=" + userId + "]";
	}

}
