package bookstore.domain;

public class TradeItem {
	private Integer tradeItemId;
	// 和TradeItem关联的Book
	private Book book;
	private int quantity;
	// 和TradeItem关联的Bookid和tradeid
	private Integer bookId;
	private Integer tradeId;

	public TradeItem(Integer tradeItemId, Integer bookId, int quantity,
					 Integer tradeId) {
		super();
		this.tradeItemId = tradeItemId;
		this.bookId = bookId;
		this.quantity = quantity;
		this.tradeId = tradeId;
	}

	public TradeItem() {
	}

	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public String toString() {
		return "TradeItem [tradeItemId=" + tradeItemId + ", book=" + book
				+ ", quantity=" + quantity + ", bookId=" + bookId
				+ ", tradeId=" + tradeId + "]";
	}

}
