package co.kr.ezen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.book.BookRegister;
import com.naver.Command;
import com.naver.DeleteCommand;
import com.naver.EndCommand;
import com.naver.InsertCommand;
import com.naver.SelectCommand;
import com.naver.UpdateCommand;

public class MainEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Command[] coms = {new InsertCommand(), new SelectCommand(),
				new UpdateCommand(), new DeleteCommand(), new EndCommand()};
		
		List<Command> list = new ArrayList<Command>();
		list.add(new InsertCommand());
		list.add(new SelectCommand());
		list.add(new UpdateCommand());
		list.add(new DeleteCommand());
		list.add(new EndCommand());
		
		BookRegister book = new BookRegister();
		
		boolean isOk = true;
		
		int idx = -1;
		System.out.println("Ebook 관리 시스템입니다.");
		try {
			while (isOk) {
				System.out.println("원하시는 메뉴를 선택해주세요");
				for(int i =1; i < list.size(); i++) {
					Command com = list.get(i);
					System.out.print(" " + i + ".");
					System.out.print(com);
					
					if (i != list.size()-1) {
						System.out.print(", ");
					}
				}
				System.out.println();
				System.out.println("--------------------------------------------------------------");
				idx = sc.nextInt();
				sc.nextLine();
				
				if (idx == coms.length) {
					break;
				}
				list.get(idx).execute(sc);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			sc.close();
			
		}
		
		
	}

}
