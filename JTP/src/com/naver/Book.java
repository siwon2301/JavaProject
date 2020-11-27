package com.naver;

import java.io.Serializable;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String name;
	private String genre;
	private int price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int code, String name, String genre, int price) {
		super();
		this.code = code;
		this.name = name;
		this.genre = genre;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
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
		Book other = (Book) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [code=" + code + ", name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}

}
