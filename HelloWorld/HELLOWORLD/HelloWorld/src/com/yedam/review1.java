package com.yedam;

import java.time.LocalDate;
import java.util.Scanner;

public class review1 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();

		test01();
		// test02();
	}// end main

	public static void test01() {
		Scanner scn = new Scanner(System.in);
		String result = "친구목록은 ";
		boolean first = true;
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit");
			String msg = scn.nextLine();
			if (msg.equals("quit")) {
				break;
			} // end if
			if (!first) {
				result += ",";	
			} // end if
			result += msg;
			first = false;
			System.out.println(result + "입니다.");
		} // end while
		System.out.println("end of prog");
	}// end test01

	public static void test02() {
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			int num1 = (int) (Math.random() * 71) + 30;
			sum += num1;
		} // end for
		double avg = sum / 3.0;

		System.out.println("합계는 : " + sum);
		System.out.println("평균은 : " + avg);
		System.out.println(Math.round(avg * 100) / 100.0);

	}// end test02
}// end class
