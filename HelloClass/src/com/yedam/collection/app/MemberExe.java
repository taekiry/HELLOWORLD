package com.yedam.collection.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberExe {
	
	public static void main(String[] args) {
		boolean run = true; // 반복문 실행/종료
		
		List<Member> members = new ArrayList<>(); 
//		members[0] => members.add(new Member()) 방식으로 바꾸기.
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택>> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1: // 추가.
				System.out.print("아이디를 입력>> ");
				String id = scn.nextLine();
			
				System.out.print("이름를 입력>> ");
				String name = scn.nextLine();
				
				System.out.print("전화번호를 입력>> ");
				String telNo = scn.nextLine();
				
				System.out.print("포인트를 입력>> ");
				int point = Integer.parseInt(scn.nextLine());
				
				// 멤버변수 선언과 값 할당.
//				Member member = new Member();
//				member.memberId = id;
//				member.memberName = name;
//				member.phone = telNo;
//				member.point = point;
																	//new 연산자 : 객체 생성 연산자, 객체 생성 번지를 리턴
				Member member = new Member(id,name,telNo,point);	//생성자로 다 지정해놔서 밑에 4줄쓸필요없음.
																	//member는 데이터 값 가지는게아니라 해당 클래스의 객체 번지수 참조.
//				member.setMemberId(id);;
//				member.setMemberName(name);;
//				member.setPhone(telNo);;
//				member.setPoint(point);;
				
				// 배열에 추가.
				
				members.add(member);
				System.out.println("등록완료.");
					 // 한건을 추가했으면 반복문 종료.
					
				
				break; // switch의 case 1 종료.

			case 2: // 수정.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();
				System.out.print("전화번호를 입력>> ");
				telNo = scn.nextLine();

				// 같은 값을 찾아서 변경하기.
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i) != null) {
						if (members.get(i).getMemberId().equals(id)){
							members.get(i).setPhone(telNo); 			//변수이름 같아도 실행됨. case1이 영향을 끼치지않음.
							System.out.println("수정완료.");
						}
					}
				}
				break;

			case 3: // 삭제.
				System.out.print("아이디를 입력>> ");
				id = scn.nextLine();

				// 같은 값을 찾아서 삭제하기.
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i) != null) {
						if (members.get(i).getMemberId().equals(id)) {
							//members.set(i,null);	// members의 i 값을 널로 변경
							members.remove(i);
							System.out.println("삭제완료.");
						}
					}
				}
				break;

			case 4: // 조회.
				System.out.print("이름를 입력>> ");
				name = scn.nextLine();
//				System.out.println(members.get(0).toString());
				// 조회.
				//System.out.printf("%-10s %-5s %-15s\n", "UserId", "회원명", "TelNo");
				for (int i = 0; i < members.size(); i++) {
					
					if (members.get(i) != null && (name.equals("") || name.equals(members.get(i).getMemberName()))) {
						System.out.printf("%-10s %-5s %-15s\n", members.get(i).getMemberId(), members.get(i).getMemberName(),
								members.get(i).getPhone());
					}
				}
				break;

			case 5: // 종료.
				run = false;
				break;

			default:
				System.out.println("메뉴를 다시 선택하세요.");

			}

		} // end of while.
		System.out.println("*** end of prog ***");

	} // end of main.
}
