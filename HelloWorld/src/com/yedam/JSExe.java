package com.yedam;

public class JSExe {
	
	public static void main(String[] args) {

		// 변경된 부분.
		// 로컬의 수정사항, 원격의 수정사항이 다른 충돌발생
		// 임의의 수를 생성. 1 ~ 100 사이의 임의의 값을 생성
		//Math.random() * 10; // 0<=x<10 실수 생성
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
		int result = (int)(Math.random() * 100) + 1; //실수값을 정수로 casting (int)
		sum += result;
		}
		System.out.println("결과: " + sum);
	}// end of main
	
	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 값을 누적하는 반복문
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("결과: " + sum);
	}// end of test
	
}// end of class.

	
