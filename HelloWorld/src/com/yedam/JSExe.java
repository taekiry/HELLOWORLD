package com.yedam;

import java.time.LocalDate;
import java.util.Scanner;


public class JSExe {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();
		System.out.println(now);
		//test();
		//test2(); // test2 메소드 호출
		//test3();
        //test4();
		//test5();
		test6();
		/*
		int num1 = 20;
		int num2 = 30;
		System.out.println(num1 == num2);

		String str1 = new String("Hello"); // 문자열 넣는방식
		String str2 = new String("Hello");

		System.out.println(str1);
		System.out.println(str2);
		// System.out.println(str1 == str2); // 문자열의 경우 비교연산자 사용시 false출력
		// == 연산자는 주소를 비교합니다.
		System.out.println(str1.equals(str2)); // 비교1.equals(비교2) equals 메소드
												// 참조데이터 ->기본데이터 아닌 객체,배열,인터페이스등*/

		// "30" vs. 30
		int num3 = 30;
		String str3 = "30";

//		System.out.println(str3.equals("" + num3)); // "" + num3 -> 공백 + 숫자 => 문자열로 변환

//		int num4 = Integer.parseInt(str3); // Integer 클래스의 parseInt 메소드 ->문자를 숫자타입으로 변환
//		System.out.println(num3 == num4); // 위에서 str3을 숫자타입으로 변경해서 num4에 저장 따라서 숫자 == 숫자 true

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

	public static void test2() {

		// 임의의 수를 생성. 1 ~ 100 사이의 임의의 값을 생성
		// Math.random() * 10; // 0<=x<10 실수 생성
		/*
		 * int sum = 0; for (int i = 1; i <= 5; i++) { int result = (int) (Math.random()
		 * * 100) + 1; // 실수값을 정수로 casting (int) sum += result; }
		 * System.out.println("결과: " + sum);
		 */

		// 임의의 수를 생성. 30 ~ 100 사이의 임의의 값 생성
		// 평균: 173/5 = 34.6 정수를 정수로 나누면 정수임. .6은버림 따라서 적어도하나는 실수값이어야함

		/*
		 * double sum1 = 0; for( int i = 1; i <= 5; i++) { double result =
		 * (double)(Math.random()*70) + 30; sum1 += result; } double avg = sum1/5;
		 */

		// 교수님방법 처음엔 int로 시작 마지막값에 .0 -> 정수 / 실수 = 실수

		int sum1 = 0;
		for (int i = 1; i <= 7; i++) {
			int result = (int) (Math.random() * 71) + 30;
			sum1 += result;
		}

		double avg = sum1 / 7.0;

		System.out.println("합계는 " + sum1);
		System.out.println("평균은 " + avg);
		System.out.println(Math.round(avg * 100) / 100.0);
		// 실수에 100을 곱해서 4자리수로 만들고 다시 100.0으로 소수 둘째자리까지 출력
		// 10.0 으로 나누면 소수점 1자리, 1000.0으로 나누면 소수점 3자리

	}// end of test2

	public static void test3() {
		// 사용자의 입력값을 읽어들이기.

		Scanner scn = new Scanner(System.in);   // 키보드로 입력하면 읽어준다. system.in
												// java.util은 패키지명, system은 java.language(기본패키지)가 생략된것.
												// 패키지 아래에 import하는 방식도 있음, crtl shift o 누르면 알아서 추가해줌
		int sum2 = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine();        // scn.nextLine-> scanner사용한 scn의입력값이 문자이다.입력값을 문자열형태로 value에 저장.
			int score = Integer.parseInt(value);  //if 10,20,30 쓴다면 102030으로 출력되기때문에 parseInt(value)필수
			sum2 += score;
		};
		double avg = sum2 / 3.0;
		avg = Math.round(avg * 100)/100.0; //-> avg 값을 소수점2째자리까지 출력
		System.out.println("합계: "+ sum2 + ",평균: " + avg);
	}// end of test3
	
	public static void test4() {              //while문 활용
		
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("메세지를 입력. 종료하려면 quit>>");
			String msg = scn.nextLine();
			if( msg.equals("quit")) {
				break;
			} //end of if
			System.out.println("입력한 값은" + msg);
		}//end of while
		System.out.println("end of prog.");
	}// end of test4
	
	public static void test5() {   //while문을 사용하여 홍길동,김민규,최석영 
		                           //친구목록은 ooo,ooo ... 입니다.
	    
		/*Scanner scn = new Scanner(System.in);
		String result = " ";   // = "친구목록은 "해도 누적됨.
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit");
			String msg = scn.nextLine();
			if (msg.equals("quit")) {
				result += " 입니다";
				break;
			}
			result += msg+",";
			System.out.println("친구목록은 "+ result);
		}// end of while*/
		
		//내방법도 확인해야함
		Scanner scn = new Scanner(System.in);
		String result = "친구목록은 ";   // = "친구목록은 "해도 누적됨.
		boolean first = true;
		while (true) {
			System.out.println("친구이름 입력. 종료하려면 quit");
			String msg = scn.nextLine();
			if (msg.equals("quit")) {
				result += " 입니다";
				break;
			} 
			if (!first) {                         //  if(first) { 
				result += ", ";                   //     result += msg;
			}                                     //     first = false;
			result += msg;                        //  } else {
			first = false;		                  //     result += ", " + msg;
		}// end of while                          //  }
		System.out.println(result);
		System.out.println("end of prog.");
	}//end of test5호

	public static void test6() {
		
		//printf("형식문자열", 값1, 값2....)
		System.out.printf("%s %d\n","감자",30);   //%s(string) -> 뒤의 문자값을 받아오겠습니다. %d(digit) ->뒤 정수값 받아옴
		System.out.printf("%s %.2f\n","감자",30.33); // %f -> 실수값 받아옴 /.2 -> 소수점 둘째자리까지
		System.out.println("문자");               //113pg 표 \n -> 줄바꿈
		
		//"홍길동", 100, 23.9
		System.out.printf("%s\n", "홍길동");
		System.out.printf("%d\n", 100);
		System.out.printf("%.1f\n",23.9);
		
		//안녕하세요 이름은 김태완입니다
		//나이는 20세 입니다.
		//몸무게는 67.8입니다.
		
		//System.out.printf("%s\n%s %d%s\n%s %.1f%s","안녕하세요 김태완입니다.","나이는",20,"세 입니다.","몸무게는",67.8,"입니다.");
		
		//System.out.printf("%s\n", "안녕하세요 김태완입니다.");
		//System.out.printf("%s %d%s\n","나이는",20,"세 입니다.");
		//System.out.printf("%s %d %s");
		
		//교수님
		String formatStr = "안녕하세요 %s입니다.\n";
		formatStr += "나이는 %d세입니다.\n";
		formatStr += "몸무게는 %.1f입니다.\n";
		System.out.printf(formatStr, "김태완",20,67.8);
		
		
	}//end test6
	
}// end of class.
