package com.book;

import java.io.Serializable;

public class BookDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookName;
	private int bookCode;
	private int price;
	private int point;
	private String borrowing;
	private String returning;
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(String bookName, int bookCode, int price, int point, String borrowing, String returning) {
		super();
		this.bookName = bookName;
		this.bookCode = bookCode;
		this.price = price;
		this.point = point;
		this.borrowing = borrowing;
		this.returning = returning;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getborrowing() {
		return borrowing;
	}

	public void setborrowing(String borrowing) {
		this.borrowing = borrowing;
	}

	public String getReturning() {
		return returning;
	}

	public void setReturning(String returning) {
		this.returning = returning;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookCode;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((borrowing == null) ? 0 : borrowing.hashCode());
		result = prime * result + point;
		result = prime * result + price;
		result = prime * result + ((returning == null) ? 0 : returning.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		if (bookCode != other.bookCode)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (borrowing == null) {
			if (other.borrowing != null)
				return false;
		} else if (!borrowing.equals(other.borrowing))
			return false;
		if (point != other.point)
			return false;
		if (price != other.price)
			return false;
		if (returning == null) {
			if (other.returning != null)
				return false;
		} else if (!returning.equals(other.returning))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "책 이름:" + bookName + "가격: " + price + "적립 포인트: " + point;
	}
	
	
	

}
