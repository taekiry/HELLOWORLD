package com.yedam;

//정렬 crtl+shift+f
public class HelloJava {
	public static void main(String[] args) {
	// main적고 crtl+shift+enter
	/* 기본 데이터타입
	 * int : 정수
	 * double : 실수
	 * boolean: 참/거짓
	 */
		int num1 = 10;           //변수 num1을 초기화.(변수할당)
		//int num1 = 10.0;       //compile시 에러나면 밑줄
		double num2 = 20;        // 자동형변환(promotion)이 발생 실수 > 정수
		
		//num1 = num2;           //데이터 타입 다름 실수 = 정수
		num1 = (int) num2;       // 강제형변환(casting)
		
		int num3 = 100;
		double num4 =200;
		/*double result = num3 + num4; */
		//int result = num3 + num4; 더할시 num3 실수로 자동형변환되서 왼쪽은 정수 오른쪽은 실수 오류
		double result = (double) num3 + num4;
		System.out.println("결과는 " + result);

	    // 20 + 30 => 50
		System.out.println(20 + 30);
		System.out.println("결과는 " + 20 + 30);   //문자열이 추가되면 문자열로 인식 
		System.out.println("결과는 " + (20 + 30)); //int 타입부터 먼저 연산후 문자열추가
			
	}
}
