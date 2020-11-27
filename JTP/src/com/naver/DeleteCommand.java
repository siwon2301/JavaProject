package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("회원 삭제를 진행합니다.");

		System.out.println("삭제할 id를 입력해주세요.");
		String id = sc.nextLine();

		userDTO dto = new userDTO(id, null, 0, 0);
		userDAO dao = new userDAO();
		dao.delete(dto);

	}

	@Override
	public String toString() {
		return "회원 삭제";
	}

}
