package kr.co.book;

import java.util.ArrayList;
import java.util.Scanner;

public class CheckBook implements CommandBook {
	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();

	@Override
	public void execute(Scanner sc) throws InterruptedException {
	while(true) {
		System.out.println("�ش� ���� ��ȣ�� �Է����ּ���");
		String temp = sc.nextLine();
		int cnt = 0;
		for(int i = 0; i <booklist.size(); i++) {
			if (temp.equals(booklist.get(i).getBcode())) {
				cnt++;
				boolean bStatus = booklist.get(i).getbAvailable();
				
				if (bStatus) {
					bStatus = false;
					System.out.println("������ �뿩�Ǿ����ϴ�");
				} else {
					bStatus = true;
					System.out.println("������ �ݳ��Ǿ����ϴ�.");
				}
				booklist.get(i).setbAvailable(bStatus);
				break;
			}
		}
		if (cnt == 0) {
			System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���");
		} else {
			break;
		}
	}
	}

	@Override
	public String toString() {
		return "�뿩/�ݳ� ��ȸ";
	}

}
