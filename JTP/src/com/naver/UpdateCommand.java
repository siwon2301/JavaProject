package com.naver;

import java.util.Scanner;

public class UpdateCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		System.out.println("회원 이름을 변경합니다.");
		
		System.out.println("가입된 id를 입력해주세요.");
		String id = sc.nextLine();
		
		System.out.println("변경할 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		userDAO dao = new userDAO();
		userDTO dto = new userDTO(id, name, 0, 0);
		dao.update(dto);
		
	}

	@Override
	public String toString() {
		return "회원 이름 수정";
	}
	
}
