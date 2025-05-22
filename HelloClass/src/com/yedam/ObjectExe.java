package com.yedam;

import java.util.Scanner;

public class ObjectExe {        			//객체안에 두가지 필드 : 속성 메소드 : 동작(기능)
											//인스턴스화 -> 클래스를 실체화 클래스를 인스턴스로 만들어야 기능이작동
	public static void main(String[] args) {
		//Calendar.showMonth();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("년도를 입력하세요>> ");
		int year = 0;
		try {
		year = Integer.parseInt(scn.nextLine());
		
		} catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
		
		boolean lyear = Calendar.isLeapYear(year);
		if(lyear) {
			System.out.printf("%d는 윤년입니다!",year);
		} else {
			System.out.printf("%d는 평년입니다!",year);
		}
	}
}// end ObjectExe