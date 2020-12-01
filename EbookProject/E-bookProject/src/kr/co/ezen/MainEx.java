package kr.co.ezen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naver.Command;
import com.naver.DeleteCommand;
import com.naver.EndCommand;
import com.naver.InsertCommand;
import com.naver.SelectCommand;
import com.naver.UpdateCommand;

import kr.co.book.BookDAO;
import kr.co.book.BookDTO;
import kr.co.book.CommandBook;
import kr.co.book.DeleteBook;
import kr.co.book.EndBook;
import kr.co.book.InsertBook;
import kr.co.book.SelectAllBook;
import kr.co.book.SelectBook;
import kr.co.book.UpdateBook;

public class MainEx {

	@Override
	public void run() {
		Command[] coms = {new InsertCommand(), new SelectCommand(),
				new UpdateCommand(), new DeleteCommand(), new EndCommand()};
		List<Command> list = new ArrayList<Command>();
		list.add(new InsertCommand());
		list.add(new SelectCommand());
		list.add(new DeleteCommand());
		list.add(new UpdateCommand());
		list.add(new EndCommand());
		
		int sum = 0;
		for(int i = 0; i< list.size(); i++) {
			Command com = list.get(i);
			System.out.println(i + ":");
			System.out.println(com);
			
			if (i != list.size()-1) {
				System.out.println(", ");
			}
		}
		

	}
	public static void main(String[] args) throws InterruptedException {
		
		MainEx t = new MainEx();
		t.start();
		
		CommandBook[] bcom = {new InsertBook(), new SelectAllBook(), new SelectBook(),
				new UpdateBook(), new DeleteBook(), new EndBook()};
		
		List<CommandBook> list2 = new ArrayList<CommandBook>();
		list2.add(new InsertBook());
		list2.add(new SelectAllBook());
		list2.add(new SelectBook());
		list2.add(new UpdateBook());
		list2.add(new DeleteBook());
		list2.add(new EndBook());
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		Command[] coms = {new InsertCommand(), new SelectCommand(),
//				new UpdateCommand(), new DeleteCommand(), new EndCommand()};
//		
//		CommandBook[] bcom = {new InsertBook(), new SelectAllBook(), new SelectBook(),
//				new UpdateBook(), new DeleteBook(), new EndBook()};
//		
//		while (true) {
//			System.out.println("Ebook 관리 시스템입니다.");
//			System.out.println("원하시는 메뉴를 선택해주세요");
////			System.out.println("0: 등록, 1: 조회, 2: 수정, 3: 삭제, 4: 종료");
//			System.out.println("5: 도서입력, 6: 모든 도서조회, 7: 도서조회, 8: 도서수정, 9:도서삭제");
//			System.out.println("---------------------------------------");
//			int idx = sc.nextInt();
//			sc.nextLine();
//			bcom[idx].execute(sc);
////			coms[idx].execute(sc);
			
			
			
//			sc.close();
		}
	private void start() {
		// TODO Auto-generated method stub
		
	}
			
	}
		}

//		List<Command> list = new ArrayList<Command>();
//		list.add(new InsertCommand());
//		list.add(new SelectCommand());
//		list.add(new UpdateCommand());
//		list.add(new DeleteCommand());
//		list.add(new EndCommand());
//		
//		List<CommandBook> list2 = new ArrayList<CommandBook>();
//		list2.add(new InsertBook());
//		list2.add(new SelectAllBook());
//		list2.add(new SelectBook());
//		list2.add(new UpdateBook());
//		list2.add(new DeleteBook());
//		
//		boolean isOk = true;
//		
//		int idx = -1;
//		System.out.println("Ebook 관리 시스템입니다.");
//		try {
//			while (isOk) {
//				System.out.println("원하시는 메뉴를 선택해주세요");
//				for(int i =0; i < list.size(); i++) {
//					Command coms2 = list.get(i);
//					System.out.print(" " + i + ".");
//					System.out.print(coms);
//					
//					if (i != list.size()-1) {
//						System.out.print(", ");
//					}
//				}
//				System.out.println();
//				System.out.println("--------------------------------------------------------------");
//				idx = sc.nextInt();
//				sc.nextLine();
//					while (isOk) {
//						for(int i =0; i < list2.size(); i++) {
//							CommandBook bcom2 = list2.get(i);
//							System.out.print(" " + i + ".");
//							System.out.print(bcom);
//						
//							if (i != list2.size()-1) {
//								System.out.print(", ");
//							}
//						}
//					
//				
//				if (idx == coms.length) {
//					break;
//				}
//				list.get(idx).execute(sc);
//			}	
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sc.close();
//		}			
//	}		
//}
