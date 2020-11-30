package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectAllBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	BookDTO book = new BookDTO();

	@Override
	public void execute(Scanner sc) throws InterruptedException {
		ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
		while (true) {
			System.out.println("보유 도서량 : " + booklist.size());
			for (int i = 0; i < booklist.size(); i++) {
				System.out.println("=============================");
				System.out.println("책 번호 : " + booklist.get(i).getBcode());
				System.out.println("책 제목 : " + booklist.get(i).getbName());
				System.out.println(" 장 르 : " + booklist.get(i).getbGenre());
				System.out.println("대여가능 : " + booklist.get(i).getbAvailable());

				System.out.println("초기 메뉴 이동: [b] \t 프로그램 종료 : [0]");
				String temp = sc.nextLine();
				if (temp.equalsIgnoreCase("b")) {
					break;
				} else if (temp.equals("0")) {
					System.out.println("프로그램을 종료합니다.");
					Thread.sleep(1000);
					System.exit(0);
				} else {
					System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다");
					Thread.sleep(1000);
					break;
				}
			}
			System.exit(0);
		}

	}

	@Override
	public String toString() {
		return "도서 정보 조회";
	}

}
