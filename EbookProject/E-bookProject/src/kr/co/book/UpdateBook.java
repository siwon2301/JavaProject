package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();

	@Override
	public void execute(Scanner sc) {
		while (true) {
			System.out.println("수정 할 책의 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < booklist.size(); i++) {
				if (temp.equals(booklist.get(i).getBcode())) {
					System.out.println("새로운 제목 입력");
					booklist.get(i).setbName(sc.nextLine());
					System.out.println("새로운 장르 입력");
					booklist.get(i).setbGenre(sc.nextLine());
					cnt++;
					System.out.println("도서 수정 완료");
					break;
				}
			}
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요");

			} else {
				break;
			}
		}

	}

	@Override
	public String toString() {
		return "도서 정보 수정";
	}

}
