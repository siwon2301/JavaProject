package com.naver;

import java.util.Scanner;

public class InsertCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("회원 가입 절차를 시작합니다.");
		
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.println("추가 할 금액을 입력하세요");
		int cash = sc.nextInt();
		sc.nextLine();
		
		System.out.println("회원 가입이 완료 되었습니다.");
		System.out.println("감사합니다.");
		
		MemberDTO dto = new MemberDTO(id, name, cash, 0, null);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
}

	@Override
	public String toString() {
		return "회원 가입";
	}
	


}
