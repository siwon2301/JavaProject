package com.naver;

import java.util.Scanner;

public class InsertCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		
		System.out.println("ȸ�� ���� ������ �����մϴ�.");
		
		System.out.println("���̵� �Է��ϼ���.");
		String id = sc.nextLine();
		
		System.out.println("�̸��� �Է��ϼ���");
		String name = sc.nextLine();
		
		System.out.println("�߰� �� �ݾ��� �Է��ϼ���");
		int cash = sc.nextInt();
		sc.nextLine();
		
		System.out.println("ȸ�� ������ �Ϸ� �Ǿ����ϴ�.");
		System.out.println("�����մϴ�.");
		
		MemberDTO dto = new MemberDTO(id, name, cash, 0, null);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(dto);
}

	@Override
	public String toString() {
		return "ȸ�� ����";
	}
	


}
