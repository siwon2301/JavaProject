package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	@Override
	public void execute(Scanner sc) throws InterruptedException {
		while (true) {
			System.out.println("검색 할 책의 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for(int i = 0; i <booklist.size(); i++) {
				if (temp.equals(booklist.get(i).getBcode())) {
					System.out.println("==============================");
					System.out.println("책 코드 : " + booklist.get(i).getBcode());
					System.out.println("책 제목 : " + booklist.get(i).getbName());
					System.out.println(" 장 르 : " + booklist.get(i).getbGenre());
					System.out.println("대여가능 : " + booklist.get(i).getbAvailable());
					System.out.println("==============================\n");
					cnt++;
					break;
				}
			}
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요");
				
			}else {
				break;
			}
		}
		
	}

}
