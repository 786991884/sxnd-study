package ch08.estore;

import java.io.Serializable;

public class SalesLine implements Serializable {

	private static final long serialVersionUID = 1L;
	private int num;
	private Book book;

	public SalesLine(int num, Book book) {
		this.num = num;
		this.book = book;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
