package com.yedam.ref;

public class ArrayExe1 {
	// class 영역 -> 생성자, 메소드, 필드 선언

	public static void main(String[] args) {

		// test3();
		// test4();
		// test5();
		// test6();
		test2();
		// int 배열 => intAry : 10, 17, 22, 31, 55, 24

		int[] intAry = { 10, 17, 22, 31, 55, 24 };

		/*
		 * // 요소의 합. 
		 * int sum = 0; 
		 * for (int i = 0; i < intAry.length; i += 2) { 
		 * sum += intAry[i]; 
		 * System.out.printf("sum : %d, i: %d 값:%d\n", sum, i, intAry[i]);
		 * }
		 * 
		 * sum = 0; for (int i = 0; i < intAry.length; i++) { if (i % 2 == 0) { sum +=
		 * intAry[i]; System.out.printf("sum : %d, i: %d 값:%d\n", sum, i, intAry[i]); }
		 * } // 짝수번째 값들의 합
		 * 
		 * sum = 0; for (int i = 0; i < intAry.length; i++) { if (intAry[i] % 2 == 0) {
		 * sum += intAry[i]; System.out.printf("sum : %d, i: %d 값:%d\n", sum, i,
		 * intAry[i]); } } // 짝수값들의 합
		 * 
		 * sum = 0; int cnt = 0; for (int i = 0; i < intAry.length; i++) { if (intAry[i]
		 * % 2 == 0) { sum += intAry[i]; cnt++;
		 * System.out.printf("sum : %d, i: %d 값:%d\n", sum, i, intAry[i]);
		 * 
		 * } } double avg = 1.0 * sum / cnt; // sum을 실수타입으로 변환
		 * System.out.printf("평균: %.1f\n", avg); // 짝수합의 평균
		 * 
		 * // 배열요소 중 최고값.
		 * 
		 * int max = 0; for (int i = 0; i < intAry.length; i++) { if (max < intAry[i]) {
		 * max = intAry[i]; } } System.out.printf("최대값은 : %d\n", max); if (max != 0) {
		 * return; }
		 */

		// 배열속 데이터 값 정렬 (<<<<<<<<<<<<<<<<<<<<<<<<<<다시 해보자ㅏ)
		/*int temp = 0;
		int[] intAry1 = { 10, 17, 22, 31, 55, 24 };

		for (int j = 0; j < intAry1.length - 1; j++) { //앞뒤비교 -> length보다 하나 작은값
			for (int i = 0; i < intAry1.length - 1; i++) {
				if (intAry1[i] < intAry1[i + 1]) {
					temp = intAry1[i];
					intAry1[i] = intAry1[i + 1];
					intAry1[i + 1] = temp;
					System.out.println(temp);
				}

			}

		}

		for (int i = 0; i < intAry1.length; i++) {
			System.out.printf("i: %d 값:%d\n", i, intAry1[i]);
		}
		if (temp == 0) {
			return;
		}*/

	}// end main

	public static void test3() {
		// 3.주사위 두개 math.random 눈의 합이 5가 아니면 주사위 계속, 5면 실행을 멈춤

		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d,%d)\n", dice1, dice2);
			int sum = dice1 + dice2;
			if (sum == 5) {
				break;
			}
		} // end while

	}// end test3

	public static void test4() {

		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d,%d)\n", x, y);
				}
			}

		} // end for

	}// end test4

	public static void test5() {

		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (inner <= outer) {
					System.out.print("*");
				}
			}
			System.out.println(); // 줄바꿈
		}

	}// end test5

	public static void test6() {

		for (int outer = 1; outer <= 4; outer++) {
			for (int inner = 1; inner <= 4; inner++) {
				if (outer + inner <= 5) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}// end test6
	
	public static void test2() {
		// math.random -> 10 ~ 100 사이의 점수를 생성.
		// 학생 10명의 점수를 생성해서 학생 점수의 평균을 구하고 최고 점수가 몇점인지 구하라
		
		int temp = 0;
		int[] scoreAry = new int[10];

		int sum = 0;
		for (int i = 0; i < scoreAry.length; i++) {
			int scr = (int) (Math.random()*91)+10;
			scoreAry[i] = scr;
			sum += scoreAry[i];
			System.out.println(scoreAry[i]);
			
			if (temp < scoreAry[i]) {
				temp =  scoreAry[i];
			}		
		}	
		
		double avg = 1.0 * sum / scoreAry.length;
		System.out.printf("평균은 :%.1f, 최고값은 : %d", avg, temp);
		
		
		
	}//end test2

}// end class