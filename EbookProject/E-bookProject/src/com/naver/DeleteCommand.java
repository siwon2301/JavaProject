package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		System.out.println("회원정보를 삭제를 합니다.");
		System.out.println("아이디를 입력하세요");
		String id = sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, null, 0, 0, null);
		
		System.out.println("삭제가 완료되었습니다.");
		MemberDAO dao = new MemberDAO();
		dao.delete(dto);	
	}

	@Override
	public String toString() {
		return "계정 삭제";
	}
	
	

}
