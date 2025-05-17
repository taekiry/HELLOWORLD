	package com.yedam.ref;

import java.util.Scanner;

public class ToDoExe {
	
	public static void main(String[] args) {
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scn = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택 >> ");
			
			int selectNo = Integer.parseInt(scn.nextLine());
			
			if(selectNo == 1) {
				System.out.print("학생수 >> ");
				studentNum = Integer.parseInt(scn.nextLine());
			} else if (selectNo == 2) {
				scores = new int[studentNum];
				for (int i = 0; i < studentNum; i++) {
					scores[i] = Integer.parseInt(scn.nextLine());
					System.out.printf("scores[%d]> %d\n",i,scores[i]);
					}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d] > %d\n",i,scores[i]);
				}	
				
			} else if (selectNo == 4) {
				int max = 0;
				int sum = 0;				
				for (int i = 0; i < studentNum; i++) {
					sum += scores[i];
					if ( max < scores[i]) {
						max = scores[i];
					}
				} 
				double avg = 1.0 * sum / studentNum;
				System.out.printf("최고 점수 : %d\n평균 점수 : %f\n",max,avg);
			} else if (selectNo == 5) {
				run = false;
				
			}
			
		}//end while
		System.out.println("프로그램 종료");
		
		
	}//end main
}//end class
