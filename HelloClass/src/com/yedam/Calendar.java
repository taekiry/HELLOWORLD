package com.yedam;

import java.util.Scanner;

public class Calendar {
	static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		//============================
		//                   1   2   3
		//   4   5   6   7   8   9  10 ...
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("월을 입력하세요");
		int month = Integer.parseInt(scn.nextLine());
		int space = getSpace(month);
		int day = lastDate(month);
		System.out.printf("         2025년 %d월\n",month);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		for (int i = 1; i <= getSpace(month); i++) {
			System.out.printf("%4s"," ");
		}
		
		for( int i = 1; i <= day; i++) {
			System.out.printf("%4d",i);
			if ( (i + space) % 7 == 0 ) {
				System.out.println();
			}
		}
	}//end showMonth()	
	
	
	public static int getSpace(int month) {
		int space = 0;
		switch(month) {
		case 1:
			space = 3;
			break;
		case 5: 
			space = 4;
			break;
		case 6: 
			space = 0;
		default :
			space = 0;
			break;
		}
		return space;
	}
	
	public static int lastDate(int month) {
		int lastDay = 0;
		switch(month) {
		case 1:
			lastDay = 31;
			break;
		case 5: 
			lastDay = 31;
			break;
		case 6: 
			lastDay = 30;
		default :
			lastDay = 31;
			break;
		}
		return lastDay;
	}

	//윤년구하기
	
	static boolean isLeapYear(int year) {
		if(year == 0) {
			return false;
		}
		//내 방식
//		if(year % 4 != 0) {
//			return false;
//		} else if(year % 100 != 0) {
//			return true;
//		} else if(year % 400 == 0) {
//			return true;
//		} else {
//			return false;
//		}	
		// 효준씨 방식
		if (year % 4 ==0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;	
	} //end isLeapYear 
	
	
//	else {
//		if (year % 100 != 0) {
//			System.out.printf("%d는 윤년입니다.",year);
//		return true;
//		} else {
//			if(year % 400 == 0) {
//				System.out.printf("%d는 윤년입니다.",year);
//				return true;
//			}
//			System.out.printf("%d는 윤년이 아닙니다!",year);
//			return false;
//		}
//	
//   인터넷 참고
//	if(a%4 == 0){
//        if(a%400 != 0 && a%100 == 0)
//            System.out.println("0");
//        else
//            System.out.println("1");
//    }
//    else{
//        System.out.println("0");
//    }
	
//	교수님 방식
//	static boolean isLeapYear(int year) {
//		// 윤년이면 true, 평년이면 false.
//		boolean leapYear = true;
//		if (year % 4 != 0) {
//			leapYear = false;
//		}
//		if (leapYear && year % 100 == 0) {
//			leapYear = false;
//		}
//		if (!leapYear && year % 400 == 0) {
//			leapYear = true;
//		}
//		return leapYear;
//		}
//	} // end of isLeapYear.
	
}//end class
