package com.naver;

import java.util.Scanner;

public class DeleteCommand implements Command {

	@Override
	public void execute(Scanner sc) {

		System.out.println("ȸ�������� ������ �մϴ�.");
		System.out.println("���̵� �Է��ϼ���");
		String id = sc.nextLine();
		
		MemberDTO dto = new MemberDTO(id, null, 0, 0, null);
		
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		MemberDAO dao = new MemberDAO();
		dao.delete(dto);	
	}

	@Override
	public String toString() {
		return "���� ����";
	}
	
	

}
