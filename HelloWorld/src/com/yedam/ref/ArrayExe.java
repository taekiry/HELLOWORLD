package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {

	public static void main(String[] args) {

	// strAry();
		// delAry();
		friendApp();
	}// end main

	// 문자열배열.
	public static void strAry() { // strAry라는 메소드 생성 실행하려면 main 메소드에

		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10]; // 변수 stringAry에 10개 크기의 배열 할당.

		// 반복문 - > 데이터 추가하기
		while (true) {
			System.out.print("이름을 입력>> ");
			String name = scn.nextLine();

			if (name.equals("quit")) {
				break;
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null)이 있는지 체크 -> null 값 대신 넣어야되니까
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공");
					break; // 한건 입력후 break 안하면 전부 첫번째 값으로 들어감
				}
			} // end for

		} // end while

		// 입력값을 출력 if로 null값들 필터링
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("\nstringAry의 [%d]번째 값 : %s", i, stringAry[i]);
			}
		} // end for

		System.out.printf("\nend of prog"); // Unreachable code : while 문 무한반복이면 이 코드에 접근불가

	}// end strAry

	public static void delAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10];
		// sample data => 홍길동을 지우고 싶다 -> 초기값인 null로 변환
		stringAry[0] = "홍길동";
		stringAry[1] = "김친구";
		stringAry[2] = "김태완";
		stringAry[3] = "김태희";

		System.out.print("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) { // 나머지 6개의 값이 null이기 때문에 equals를 쓰면
																		// nullPointerException에러
				stringAry[i] = null; // 삭제
			}
		} // end for

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("\nstringAry의 [%d]번째 값 : %s", i, stringAry[i]);
			}
		} // end for

		System.out.printf("\nend of prog"); 

	}// end delAry

	public static void friendApp() {

		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");

			// 메뉴선택
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 이름 추가
				System.out.println("이름입력>> ");
				String name = scn.nextLine();

				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = name;
						break; // 브레이크시 switch로 올라갓는데 case1이 break ->while부터 다시 
					} else { //else의 의미 -> friendAry[i]가 null이 아니면
						if (friendAry[i].equals(name)) {
							System.out.println("추가하시겠습니까? 1.추가 2.취소");
							int select = Integer.parseInt(scn.nextLine());
							//1을 선택했을시 break가 없어서 다시 for로 돌아간다
							
							if (select == 2) {
								break;
							}
						}
					} // end if
				} // end for
				break;
			case 2: // 목록 확인
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("\n[%d]번째 이름은: %s\n", i, friendAry[i]);
					}
				}
				break;

			case 3: // 삭제
				System.out.print("삭제할친구 이름>>");
				String name1 = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(name1)) {
						friendAry[i] = null;
					} else if (friendAry[i] != null && !friendAry[i].equals(name1)) {
						System.out.println("찾는이름이 없습니다");
					}
				}
				break;

			case 4:// 종료
				System.out.println("종료합니다.");
				run = false;

			}// end switch

		} // end while
		System.out.println("end of prog");
	}// end friendApp
}// end class
