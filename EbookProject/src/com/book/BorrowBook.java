package com.book;

import java.util.Scanner;

import com.naver.Command;

public class BorrowBook implements Command {

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		
		System.out.println("대여 할 책을 입력하세요.");
		
		
	}

	@Override
	public String toString() {
		return "도서 대여";
	}
	
	

}
