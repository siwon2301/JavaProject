package com.naver;

import java.util.List;
import java.util.Scanner;

public class SelectCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.select();
		
		for(int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
			System.out.println(dto);
		}
		
	}

	@Override
	public String toString() {
		return "회원 조회";
	}
	
	
}
