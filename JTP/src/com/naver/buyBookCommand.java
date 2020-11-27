package com.naver;

import java.util.Scanner;

public class buyBookCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("구매할 도서 번호를 입력해주세요.");
		int num = sc.nextInt();
		sc.nextLine();
		
		userDAO dao = new userDAO();
		userDTO dto = new userDTO(id, name, cash, point);
		Book book = new Book(code, name, genre, price);
		dao.buybook(dto, book);
	}

	@Override
	public String toString() {
		return "도서 구매";
	}
	
	

}
