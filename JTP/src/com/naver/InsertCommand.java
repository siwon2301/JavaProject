package com.naver;

import java.util.Scanner;

public class InsertCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("회원 가입을 시작합니다.");

		System.out.println("id를 입력해주세요.");
		String id = sc.nextLine();

		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();

		userDTO dto = new userDTO(id, name, 0, 0);
		userDAO dao = new userDAO();
		dao.insert(dto);

	}

	@Override
	public String toString() {
		return "회원 가입";
	}

}
