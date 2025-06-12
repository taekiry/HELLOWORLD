package com.yedam.ref;

import java.util.Scanner;

public class ToDoExe {

	public static void main(String[] args) {

		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		boolean isEmpty = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			
			//배열의 선언없이 메뉴를 선택할 경우에 NullPointer예외발생
			 if(selectNo == 2 || selectNo ==3 || selectNo ==4) {
			 	 if(scores == null) {
			 		System.out.println("학생수를 지정하세요.");
			  		continue; 
			  }
			 }// ---> 이방법쓰면 1번 안눌렀을시 발생 
			
			if (selectNo == 1) {	
				
				System.out.print("학생수 >> ");
				studentNum = Integer.parseInt(scn.nextLine());	
				scores = new int[studentNum];  		      // 학생수를 지정하면 배열의 크기가 생기게
			} else if (selectNo == 2) {
				
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i); //print와 같이 옆에 적을수있음, format지정은가능
					scores[i] = Integer.parseInt(scn.nextLine());
					isEmpty = false;
//					System.out.println();  => 줄바꿈 용도
				}
			} else if (selectNo == 3) {
				
				if (isEmpty) {
					System.out.println("먼저 점수를 입력해주세요.");
					continue;
				} else {
					for (int i = 0; i < studentNum; i++) {
						System.out.printf("scores[%d] > %d \n", i, scores[i]);
					}
				}
			} else if (selectNo == 4) {
				
				int max = 0;
				int sum = 0;
				if (isEmpty) {
					System.out.println("먼저 점수를 입력해주세요.");
					continue;
				} else {
					for (int i = 0; i < studentNum; i++) {
						sum += scores[i];
						if (max < scores[i]) {
							max = scores[i];
						}
					}
				}
				
				double avg = 1.0 * sum / studentNum;
				System.out.printf("최고 점수 : %d\n평균 점수 : %.2f\n", max, avg);
				
			} else if (selectNo == 5) {
				run = false;
				
			}
		} // end while
		scn.close();
		System.out.println("프로그램 종료");
		
	}// end main
}// end class
