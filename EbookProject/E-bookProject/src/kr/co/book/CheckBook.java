package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();

	@Override
	public void execute(Scanner sc) throws InterruptedException {
	while(true) {
		System.out.println("해당 도서 번호를 입력해주세요");
		String temp = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i <booklist.size(); i++) {
			if (temp.equals(booklist.get(i).getBcode())) {
				cnt++;
				boolean bStatus = booklist.get(i).getbAvailable();
				
				if (bStatus) {
					bStatus = false;
					System.out.println("도서가 대여되었습니다");
				} else {
					bStatus = true;
					System.out.println("도서가 반납되었습니다.");
				}
				booklist.get(i).setbAvailable(bStatus);
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
		return "대여/반납 조회";
	}

}
