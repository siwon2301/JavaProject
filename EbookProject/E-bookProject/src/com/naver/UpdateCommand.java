package com.naver;

import java.util.Scanner;

public class UpdateCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		System.out.println("���� ������ �����մϴ�");
		System.out.println("�̸��� �Է��ϼ���");
		String name = sc.nextLine();
		
		System.out.println("���ο� ���̵� �Է��ϼ���");
		String id = sc.nextLine();
		
		System.out.println("�����Ͻ� �����ݾ��� �Է����ּ���");
		int cash = sc.nextInt();
		sc.nextLine();
		
		System.out.println("�����Ͻ� ����Ʈ�� �Է����ּ���");
		int point = sc.nextInt();
		sc.nextLine();
		
		System.out.println("�����Ͻ� ���������� �Է����ּ���");
		String books = sc.nextLine();
		
		
		
		MemberDTO dto = new MemberDTO(id, name, cash, point, books);
		
		MemberDAO dao = new MemberDAO();
		dao.update(dto);
		
		
	}

	@Override
	public String toString() {
		return "ȸ�� ����";
	}

}
