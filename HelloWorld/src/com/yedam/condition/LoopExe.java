package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {

		
		test01();
		
		// while문 VS do..while문

		/*boolean run = false;

		
		 * while (run) { 
		 * System.out.println("while문"); 
		 * }
		 * System.out.println("end of prog.");
		 */

		/*do {
			System.out.println("while문"); // while문과의 차이점 한번은 무조건 실행
		} while (run);
		System.out.println("end of prog");*/

		/*do {
			System.out.println("while문"); 
		} while (run = !run);
		
		System.out.println("end of prog");*/
		
	} // end main
	
	public static void test01() {
		
		//"가위(1)","바위(2)","보(3)",종료(4)  "You Win, You lost, Same" 
		
		
		Scanner scn = new Scanner(System.in);
		
		
		
			while(true) {
				System.out.println("가위(1) 바위(2) 보(3) 종료(4) 입니다");
				int com	= (int) (Math.random()*3)+1;
				System.out.println(com);
				int me = Integer.parseInt(scn.nextLine());
				if ( com == me) {
					System.out.println("same");
				}
				if ( com == 1) {
					 if (me == 2) {
						  System.out.println("you win");
					  } else if (me == 3){
						  System.out.println("you lost");
					  }
				} if (com == 2) {
					 if(me == 1) {
						System.out.println("you lost");
					
					} else if ( me == 3) {
						System.out.println("you win");
					}
				} if (com == 3) {
					if(me == 1) {
						System.out.println("you win");
					} else if (me == 2) {
						System.out.println("you lost");
					} 		
				} 
				if(me == 4) {	
					System.out.println("종료");
					break;
				}
			}//end while
				
			
		
		/*if ( com  == 1) {
				if(me == 1) {
				  System.out.println("same");
				  //break;
			  } else if (me == 2) {
				  System.out.println("you win");
				 // break;
			  } else if (me == 3){
				  System.out.println("you lost");
				 // break;
			  }
			} else if ( com == 2){
				if(me == 1) {
					  System.out.println("you lost");
				} else if ( me == 2) {
					System.out.println("same");
				} else if ( me == 3) {
					System.out.println("you win");
				}
			} else if ( com == 3) {
				if(me == 1) {
					System.out.println("you win");
				} else if (me == 2) {
					System.out.println("you lost");
				} else if (me == 3) {
					System.out.println("Same");
				}
			} else if (me == 4) {
				System.out.println("종료합니다");
			}*/
			
		
	}//end test01
}//end class
