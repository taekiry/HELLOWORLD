package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	public static void main(String[] args) {

		// test01();
		test02();
	}// end main

	public static void test01() {
		int score = 40;

		// if문
		if (score >= 90) {
			System.out.println("A학점");
		} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		} else {
			System.out.println("불합격");
		}

		/*
		 * if (score >= 90) { System.out.println("A학점"); } if (score >= 80) {
		 * System.out.println("B학점"); } if (score >= 70) { System.out.println("C학점"); }
		 * else { System.out.println("불합격"); }
		 */// if문 따로 쓰면 값이 따로 다적용

		score = score / 10; // 95/10 -> 9 정수 /정수 -> 정수
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		}// end switch

	}// end test01

	public static void test02() {

		// 1 ~ 1000 사이의 임의의 값을 생성. 지정숫자 567
		// ex) 500입력하면 입력값보다 큽니다. 600입력하면 입력값보다 작습니다. 567입력하면 정답입니다 프로그램종료 //몇번의 시도만에
		// 정답을 맞춘지 시도횟수

		Scanner scn = new Scanner(System.in);
		int randomValue = (int) (Math.random() * 1000 + 1);
		int countNumber = 0;
		

		while (true) {
			System.out.println("1~1000사이의 값을 입력하시오");
			int number = Integer.parseInt(scn.nextLine());
			if (number > randomValue) {
				System.out.println("입력값보다 작습니다.");
				countNumber ++;
			} else if (number < randomValue) {
				System.out.println("입력값보다 큽니다.");
				countNumber ++;
			} else {
				
				System.out.println("정답입니다.");
				countNumber ++;
				break;
			}
		} // end while
		System.out.printf("임의의 값은 %d입니다. 시도회수는 %d회입니다." ,randomValue,countNumber);

	}// end test02
}// end class
