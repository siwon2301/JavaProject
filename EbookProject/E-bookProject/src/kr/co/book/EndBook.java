package kr.co.book;

import java.util.Scanner;

public class EndBook implements CommandBook {

	@Override
	public void execute(Scanner sc) throws InterruptedException {
		sc.close();
		System.exit(0);
		
	}

	@Override
	public String toString() {
		return "도서관리 종료";
	}
	
	

}
