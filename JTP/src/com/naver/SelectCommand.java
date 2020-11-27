package com.naver;

import java.util.List;
import java.util.Scanner;

public class SelectCommand implements Command{

	@Override
	public void execute(Scanner sc) {
		userDAO dao = new userDAO();
		List<userDTO> list = dao.select();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Override
	public String toString() {
		return "회원 조회";
	}
	
	
	
}
