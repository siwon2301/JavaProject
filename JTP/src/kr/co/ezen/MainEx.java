package kr.co.ezen;

import java.util.Scanner;

import com.naver.Command;
import com.naver.DeleteCommand;
import com.naver.EndCommand;
import com.naver.InsertCommand;
import com.naver.SelectCommand;
import com.naver.UpdateCommand;

public class MainEx {

	public static void main(String[] args) {

		Command[] menus = {
							new InsertCommand(), 
							new SelectCommand(), 
							new UpdateCommand(), 
							new DeleteCommand(), 
							new EndCommand() 
							};

		Scanner sc = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("메뉴를 선택하세요.");

				for (int i = 1; i < menus.length + 1; i++) {
					System.out.print(i + ": ");
					System.out.print(menus[i - 1] + "   ");
				}
				int idx = sc.nextInt();
				sc.nextLine();
				idx -= 1;
				menus[idx].execute(sc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
