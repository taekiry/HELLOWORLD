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
	
	
}//end class
