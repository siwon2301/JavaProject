package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertBook implements CommandBook {

	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	
	@Override
	public void execute(Scanner sc) throws InterruptedException {
		while (true) {
			BookDTO book = new BookDTO();
			while (true) {
				int cnt = 0;
				System.out.println("도서 번호 입력");
				String temp = sc.nextLine();
				for (int i = 0; i < booklist.size(); i++) {
					if (temp.equals(booklist.get(i).getBcode())) {
						cnt++;
						System.out.println("도서 번호 중복입니다. 다시 입력하세요");
						break;
					}
				}
				if (cnt == 0) {
					book.setBcode(temp);
					break;
				}
			}
			System.out.println("책 제목 입력");
			book.setbName(sc.nextLine());
			System.out.println("장르 입력");
			book.setbGenre(sc.nextLine());
			book.setbAvailable(true);
			Thread.sleep(1000);
			
			System.out.println("도서번호 : " + book.getBcode());
			System.out.println("도서제목 : " + book.getbName());
			System.out.println(" 장  르 :" + book.getbGenre());
//			System.out.println("대여가능 : " + book.
			
			System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
			String confirm = sc.nextLine();
			if (confirm.equalsIgnoreCase("y")) {
				booklist.add(book);
				System.out.println("=====입력완료=====");
				break;
				
			} else if(confirm.equalsIgnoreCase("n")){
				System.out.println("도서 정보를 새로 입력하세요");
			} else {
				System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다");
				break;
			}
			}
			Thread.sleep(1000);

	}

	@Override
	public String toString() {
		return "도서 정보 입력";
	}

}
