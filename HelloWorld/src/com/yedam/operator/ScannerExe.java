package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		/*while (true) {
			System.out.println("1.메뉴 2.메뉴 3.메뉴 4.종료");
			int menu = Integer.parseInt(scn.nextLine());   //Integer.parseInt("30");
			if(menu == 1) {
				System.out.println("1번메뉴를 선택했습니다.");
			} else if(menu == 2) {
				System.out.println("2번메뉴를 선택했습니다.");
			} else if(menu == 3) {
				System.out.println("3번메뉴를 선택했습니다.");
			} else if(menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1 ~ 4번 중에 선택하세요.");
			}
			
		}//end while
		System.out.println("end of prog");*/
		  
   int balance = 0; //계좌의 금액현황.  조건추가 10만원을 초과X, 마이너스금액X
   int money = 0;   //변수를 하나 더 지정해서 balance에 조건에맞으면 더해주고 맞지않으면 더하지 않는 방법.
		
		while (true) {
			
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				System.out.print("입금금액을 입력>>");
				money = Integer.parseInt(scn.nextLine());
				if(balance + money > 100000) {
					System.out.println("10만원 초과");
				} else {
					balance += money;
				}
			} else if(menu == 2) {
				System.out.println("출금액을 입력>>");
				money = Integer.parseInt(scn.nextLine());
				System.out.println(balance);
				if (balance < money ) {
					System.out.println("마이너스금액입니다");
				} else {
					balance -= money;
				}
			} else if(menu == 3) {
				if (balance >= 0) {
					System.out.println("현재 잔액>>>" + balance);	
				} else { 
					System.out.println("잔고가 부족합니다");
				}
			} else if(menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1 ~ 4번 중에 선택하세요.");
			}
			
		}//end while
		System.out.println("end of prog");
		
	
	}//end main
}//end class