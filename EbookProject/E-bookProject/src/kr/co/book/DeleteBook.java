package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	
	@Override
	public void execute(Scanner sc) {
	while (true) {
		System.out.println("���� �� å�� ��ȣ�� �Է����ּ���");
		String temp = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i <booklist.size(); i++) {
			if (temp.equals(booklist.get(i).getBcode())) {
				booklist.remove(i);
				cnt++;
				System.out.println("���� ���� �Ϸ�");
				break;
			}
		}
		if (cnt == 0) {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���");
			
		}else {
			break;
		}
	}
		
	}

	@Override
	public String toString() {
		return "���� ���� ����";
	}
	
	
}
