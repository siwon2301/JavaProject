package com.naver;

import java.util.Scanner;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("정보 수정을 시작합니다");
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("새로운 아이디를 입력하세요");
		String id = sc.nextLine();
		
		System.out.println("수정하실 보유금액을 입력해주세요");
		int cash = sc.nextInt();
		sc.nextLine();
		
		System.out.println("수정하실 포인트를 입력해주세요");
		int point = sc.nextInt();
		sc.nextLine();
		
		System.out.println("수정하실 보유도서를 입력해주세요");
		String books = sc.nextLine();
		
		
		
		MemberDTO dto = new MemberDTO(id, name, cash, point, books);
		
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
		
	}

	@Override
	public String toString() {
		return "회원 수정";
	}

}
