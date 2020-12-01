package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertBook implements CommandBook {

	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	
	@Override
	public void execute(Scanner sc) throws InterruptedException {
		while (true) {
			BookDTO book = new BookDTO();
			while (true) {
				int cnt = 0;
				System.out.println("���� ��ȣ �Է�");
				String temp = sc.nextLine();
				for (int i = 0; i < booklist.size(); i++) {
					if (temp.equals(booklist.get(i).getBcode())) {
						cnt++;
						System.out.println("���� ��ȣ �ߺ��Դϴ�. �ٽ� �Է��ϼ���");
						break;
					}
				}
				if (cnt == 0) {
					book.setBcode(temp);
					break;
				}
			}
			System.out.println("å ���� �Է�");
			book.setbName(sc.nextLine());
			System.out.println("�帣 �Է�");
			book.setbGenre(sc.nextLine());
			book.setbAvailable(true);
			Thread.sleep(1000);
			
			System.out.println("������ȣ : " + book.getBcode());
			System.out.println("�������� : " + book.getbName());
			System.out.println(" ��  �� :" + book.getbGenre());
//			System.out.println("�뿩���� : " + book.
			
			System.out.println("�Է��Ͻ� ������ ��� �½��ϱ�? ��(Y) �ƴϿ�(N)");
			String confirm = sc.nextLine();
			if (confirm.equalsIgnoreCase("y")) {
				booklist.add(book);
				System.out.println("=====�Է¿Ϸ�=====");
				break;
				
			} else if(confirm.equalsIgnoreCase("n")){
				System.out.println("���� ������ ���� �Է��ϼ���");
			} else {
				System.out.println("�߸� �����̽��ϴ�. �ʱ� �޴��� �̵��մϴ�");
				break;
			}
			}
			Thread.sleep(1000);

	}

	@Override
	public String toString() {
		return "���� ���� �Է�";
	}

}
