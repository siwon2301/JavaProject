package com.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.ldap.ManageReferralControl;


public class BookRegister {
	private static final long bookCode = 0;
	private static final String bookName = null;
	private static final String point = null;
	
	
	List<ShowAllBook> bookinfo = new ArrayList<ShowAllBook>();
	ShowAllBook list = new ShowAllBook(bookCode, bookName, point);
	
	public void setlist() {
		
		bookinfo.add(1, new ShowAllBook(001, "달러구트 꿈 백화점", "100 포인트적립"));
		bookinfo.add(2, new ShowAllBook(002, "일인칭 단수" , "200 포인트적립"));
		bookinfo.add(3, new ShowAllBook(003, "마음챙김의 시" , "100 포인트적립"));
		bookinfo.add(4, new ShowAllBook(004, "아몬드", "150 포인트적립"));
		bookinfo.add(5, new ShowAllBook(005, "인생은 소설이다", "100 포인트적립"));
	}
	
	public void print() {
		System.out.println("다운로드 가능한 책의 명단 입니다.");
		
	}
		
	
	
	public void getlist() {
		System.out.println("Code/ name/ point");
		System.out.println("------------------");
		for(ShowAllBook book : bookinfo) {
			System.out.println(book.toString());
		}
	}
}
