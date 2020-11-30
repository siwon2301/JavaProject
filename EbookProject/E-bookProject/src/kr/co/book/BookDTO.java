package kr.co.book;

import java.io.Serializable;
import java.util.ArrayList;

public class BookDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bcode;
	private String bName;
	private String bGenre;
	private int bPrice;
	private int bPoint;
	private boolean bAvailable;
	private ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(int bcode, String bName, String bGenre, int bPrice, int bPoint, boolean bAvailable,
			ArrayList<BookDTO> booklist) {
		super();
		this.bcode = bcode;
		this.bName = bName;
		this.bGenre = bGenre;
		this.bPrice = bPrice;
		this.bPoint = bPoint;
		this.bAvailable = bAvailable;
		this.booklist = booklist;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbGenre() {
		return bGenre;
	}

	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public int getbPoint() {
		return bPoint;
	}

	public void setbPoint(int bPoint) {
		this.bPoint = bPoint;
	}

	public boolean getbAvailable() {
		return bAvailable;
	}

	public void setbAvailable(boolean bAvailable) {
		this.bAvailable = bAvailable;
	}

	public ArrayList<BookDTO> getBooklist() {
		return booklist;
	}

	public void setBooklist(ArrayList<BookDTO> booklist) {
		this.booklist = booklist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bAvailable ? 1231 : 1237);
		result = prime * result + ((bGenre == null) ? 0 : bGenre.hashCode());
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + bPoint;
		result = prime * result + bPrice;
		result = prime * result + bcode;
		result = prime * result + ((booklist == null) ? 0 : booklist.hashCode());
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
		if (bAvailable != other.bAvailable)
			return false;
		if (bGenre == null) {
			if (other.bGenre != null)
				return false;
		} else if (!bGenre.equals(other.bGenre))
			return false;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (bPoint != other.bPoint)
			return false;
		if (bPrice != other.bPrice)
			return false;
		if (bcode != other.bcode)
			return false;
		if (booklist == null) {
			if (other.booklist != null)
				return false;
		} else if (!booklist.equals(other.booklist))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookDTO [bcode=" + bcode + ", bName=" + bName + ", bPrice=" + bPrice + ", bPoint=" + bPoint
				+ ", bAvailable=" + bAvailable + "]";
	}

	public void setBcode(String temp) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
