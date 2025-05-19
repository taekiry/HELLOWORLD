package com.yedam.ref.exe;

import java.util.Scanner;

public class MemberExe {
	//1.회원등록, 2.회원수정, 3.회원삭제, 4.회원조회(이름으로) 5.종료
	//1. 추가
	//	-아이디, 이름, 전화번호, 포인트
	//2. 수정
	//  -조회용(아이디) -> 전화번호(바뀔항목)
	//3. 삭제
	// 	-아이디 -> 있으면 삭제 없으면 없습니다.
	//4. 조회 
	// 	- 이름 -> 회원정보 쭈루룩
	
	public static void main(String[] args) {
		
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Member[] memberAry = new Member[100];
		

		while(run) {
			
			System.out.println("1.회원등록 2.회원수정 3.회원삭제 4.회원조회 5. 종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 2 || menu ==3 || menu ==4) {
			 	 if(memberAry[0] == null) {
			 		System.out.println("등록부터하세요.");
			  		continue; 
			  }
			}
			
			if(menu == 1 ) {
					for(int i=0; i < 100 ; i++ ) {
						System.out.print("아이디>>");
						String id = scn.nextLine();
						
						System.out.print("이름>>");
						String name = scn.nextLine();
						
						System.out.print("전화번호>>");
						String phone = scn.nextLine();
						
						System.out.print("포인트>>");
						int point = Integer.parseInt(scn.nextLine());
						
						//인스턴스 생성
						Member member = new Member();
						member.id = id;
						member.name = name;
						member.phone = phone;
						member.point = point;
						memberAry[i] = member;  //배열에 할당
						break;
						
					}
			}
			
			else if (menu == 2) {
				System.out.print("수정할 아이디>>");
				String modi = scn.nextLine();
				for(int i = 0; i < 100; i++) {
					if(memberAry[i] != null && memberAry[i].id.equals(modi)) {
						System.out.println("수정할 전화번호를 입력하세요");
						memberAry[i].phone = scn.nextLine();
						System.out.printf("수정후 : %s\n",memberAry[i].phone);
					}
				}
					
			}
			
			else if ( menu == 3) {
				
				System.out.print("삭제할 아이디>>");
				String modi2 = scn.nextLine();
				
				for(int i = 0; i < 100 ; i++) {
					if( memberAry[i] != null && memberAry[i].id.equals(modi2)) {
						memberAry[i] = null;
						System.out.println("삭제되었습니다.");
						break;
					} else {
						System.out.println("삭제할 아이디가 존재하지 않습니다.");
						break;
						
					}
				}
				
			}
			
			else if ( menu == 4) {
				System.out.print("조회할 이름>>");
				String select = scn.nextLine();

				for(int i = 0; i < 100 ; i++) {
					if( memberAry[i] != null && select.equals(memberAry[i].name)) {
						String format = "1.아이디 : %s\n2.이름 : %s\n3.전화번호 %s\n4.포인트: %d\n";
						System.out.printf(format,memberAry[i].id,memberAry[i].name,memberAry[i].phone,memberAry[i].point);
					} 
				}
			}
			
			else if ( menu == 5) {
				System.out.println("종료합니다.");
				run = false;
			}
				

		}// end while
		
		
	}// end main
}// end class
	
	

