package com.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		// test01();
		// test02();
		// test03();
		// test04();
		// test05();
		test06();
	}// end main

	// "월"정보를 입력하면 "공란"이 몇개인지 반환하는 메소드. getSpace()
	public static int getSpace(int month) { // getSpace를 호출하면 int 데이터타입을 반환하겠습니다. 변수는 int타입 month
		int space = 0;
		if (month == 3) { // 3월달
			space = 6;
		} else if (month == 4) { // 4월달 공란은 2개
			space = 2;
		} else if (month == 5) { // 5월달
			space = 4;
		} else if (month == 7) { // 7월
			space = 2;
		}
		return space;
	}// end getSpace

	// "월"정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch(month) {
		case 2: 
			lastDate = 28; 
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30; 
			break;	
		}
		return lastDate;
	}//end lastDate

	// 연습1. 증가, 감소 연산자(++, --)
	public static void test01() {

		byte num1 = 10; // byte 8칸bit on/off 2^8 첫번째는 부호 -> -128 ~ 127(0포함)
		// num1 = 128; -> error
		num1 = 127;
		num1++;
		System.out.println(num1); // 127다음 -128출력 (보수에 +1/ 컴퓨터의 음수계산방식)

		char ch1 = 'A'; // 65
		ch1 = 'B'; // 66
		ch1 = '가'; // 44032
		ch1 = 'a';
		ch1 = 0x29D7;
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);

		}

	}// end test01

	// 연습2. byte, short, long, int, char
	public static void test02() {
		byte num1 = 10;
		byte num2 = 20;
		// byte sum = num1 + num2; // error -> byte + byte = (int)결과값으로 나옴

		byte sum = (byte) (num1 + num2); // 정수연산 -> int로 타입변환
											// int sum = num1 + num2;
		System.out.println(sum);

		long num3 = 10000000000L; // ...L long형 데이터타입임을 알려줌
		long num4 = 100L;
		System.out.println(Long.MAX_VALUE);// Long 데이터타입이 가진 최고값
		System.out.println(Integer.MAX_VALUE);// Int 데이터타입이 가진 최고값

	}// end test02

	public static void test03() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);

		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("참입니다.");
		}

		result = 30;
		if (!(result > 30)) {
			System.out.println("\nresult는 30보다 작거나 같다.");

		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}

	}// end test03

	public static void test04() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // toggle 기능 (on -> off / off -> on)
		} // end for

	}// end test04

	public static void test05() {

		System.out.println(" Sun MON Tue Wed Thu Fri Sat");

		// 빈공간
		/*for (int s = 1; s <= 4; s++) {
			System.out.printf("%4s", " ");
		}

		// 날짜 출력
		for (int day = 1; day <= 31; day++) {
			System.out.printf("%4d", day); // %3d -> 3칸에 d들어감
			if (day % 7 == 3) {
				System.out.println();
			}
		}*/

		// 6월 달력
		int mon = 7; //월정보
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}

		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day); // %3d -> 3칸에 d들어감
			if ((day + space) % 7 == 0) { // 이해필요
				System.out.println();
			}
		}
	}// end test05

	//삼항연산자
	public static void test06() {
		/*String pass = "";
		int score = (int) (Math.random() * 100);
		pass = (score > 60) ? "합격입니다" : "불합격입니";
		/*if(score > 60) {
			pass = "합격";
		} else {
			pass = "불합격";
		}*/
		
		String pass = "";
		int score = (int) (Math.random() * 100);
		//pass = (score > 60) ? "합격입니다" : "불합격입니다";
		/*if(score >= 60) {
			if(score >= 80){
				pass = "우수";
			} else {
				pass = "합격";
			}
		} else {
			if(score < 20) {
				pass = "불불합격";
		} else {
				pass = "불합격";
		}*/
		pass = (score > 60) ? (score >= 80) ? "우수" : "합격" : (score < 20) ? "불불합격":"불합격";
		//길어지면 암호같으니 두개정도면 쓰자
		
		
		System.out.println(score+"점");
		System.out.println(pass);
		
			
			
			
	
	}
}// end class
