package com.yedam;

import java.util.Scanner;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드의 선언.
 * 2) 매개변수.
 * 3) 반환유형.
 */
public class Calculator {
	
	// 필드.
	// 생성자.
	// 메소드.
	
	String printStar(int times,String shape) { // 매개변수(times)
		String str = "";
		for( int i = 1; i <= times; i++) {
//			System.out.println(shape);
			str += shape + "\n";
		}
		return str;
	}//end printStar
	
	//메소드 오버로딩 -> 똑같은 메소드이름 반복 사용 but 매개변수 개수, 타입 다르게
	
	int add(int num1, int num2) {
		 return  num1 + num2 ;
	}
	double add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	double add(double num1, double num2) {
		return num1 + num2 ;
	}
	//정수배열을 매개값으로 받는 add. 반환값은 double;
	
	double add(int[] numAry) { //정수타입의 배열을 실수타입으로 자동변환
		int sum = 0;
		for(int i = 0; i < numAry.length; i++) {
			sum += numAry[i];
		}
		return sum;
	}
	
	Member getMaxPoint (Member[] memberArray) {  //멤버어레이라는 매개변수를 사용하는 getMaxPoint 메소드
	Member max = null;
	int maxPoint = 0;
		for(int i = 0; i < memberArray.length; i++) {
			if(maxPoint < memberArray[i].getPoint()) {
				maxPoint = memberArray[i].getPoint();
				max = memberArray[i];
			}
		}	
		return max; // 반환되는 max 값은 포인트를 가장 많이 갖고있는 사람의 객체
	}//end of getMaxPoint
	
	
//	Member modPhone (Member[] memberArray) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("수정할 전화번호는>");
//		String phone = scn.nextLine();
//		
//		for(int i = 0; i < memberArray.length; i++) {
//			if((memberArray[i].getPhone).eqauls(phone)) {
//				memberArray.setPhone(phone);
//			}
//		}
//	}
	
}//end class