package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectAllBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	BookDTO book = new BookDTO();

	@Override
	public void execute(Scanner sc) throws InterruptedException {
		ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
		while (true) {
			System.out.println("���� ������ : " + booklist.size());
			for (int i = 0; i < booklist.size(); i++) {
				System.out.println("=============================");
				System.out.println("å ��ȣ : " + booklist.get(i).getBcode());
				System.out.println("å ���� : " + booklist.get(i).getbName());
				System.out.println(" �� �� : " + booklist.get(i).getbGenre());
				System.out.println("�뿩���� : " + booklist.get(i).getbAvailable());

				System.out.println("�ʱ� �޴� �̵�: [b] \t ���α׷� ���� : [0]");
				String temp = sc.nextLine();
				if (temp.equalsIgnoreCase("b")) {
					break;
				} else if (temp.equals("0")) {
					System.out.println("���α׷��� �����մϴ�.");
					Thread.sleep(1000);
					System.exit(0);
				} else {
					System.out.println("�߸� �����̽��ϴ�. �ʱ�ȭ������ �̵��մϴ�");
					Thread.sleep(1000);
					break;
				}
			}
			System.exit(0);
		}

	}

	@Override
	public String toString() {
		return "���� ���� ��ȸ";
	}

}
