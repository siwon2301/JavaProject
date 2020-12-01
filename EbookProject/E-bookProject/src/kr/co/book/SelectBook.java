package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	@Override
	public void execute(Scanner sc) throws InterruptedException {
		while (true) {
			System.out.println("�˻� �� å�� ��ȣ�� �Է����ּ���");
			String temp = sc.nextLine();
			int cnt = 0;
			for(int i = 0; i <booklist.size(); i++) {
				if (temp.equals(booklist.get(i).getBcode())) {
					System.out.println("==============================");
					System.out.println("å �ڵ� : " + booklist.get(i).getBcode());
					System.out.println("å ���� : " + booklist.get(i).getbName());
					System.out.println(" �� �� : " + booklist.get(i).getbGenre());
					System.out.println("�뿩���� : " + booklist.get(i).getbAvailable());
					System.out.println("==============================\n");
					cnt++;
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

}
