package com.naver;

import java.util.Scanner;

public class EndCommand implements Command {

	@Override
	public void execute(Scanner sc) {
		sc.close();
		System.exit(0);
		
	}

	@Override
	public String toString() {
		return "시스템 종료";
	}
	
	

}
