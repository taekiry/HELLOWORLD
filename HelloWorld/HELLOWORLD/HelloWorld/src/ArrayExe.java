


	import java.util.Scanner;

	public class ArrayExe {
		public static void main(String[] args) {
			friendApp();
		}

		public static void friendApp() {
			Scanner scn = new Scanner(System.in);
			String[] friendAry = new String[10];

			boolean run = true;
			while (run) {
				System.out.println("=======================");
				System.out.println("1.추가 2.목록 3.삭제 4.종료");
				System.out.println("=======================");
				System.out.print("선택>> ");
				// 메뉴선택.
				int menu = Integer.parseInt(scn.nextLine());
				//
				switch (menu) {
				case 1: // 추가.
					System.out.print("이름입력>> ");
					String name = scn.nextLine();
					// 이름이 존재하는 지를 확인.
					boolean isExist = false;
					for (int i = 0; i < friendAry.length; i++) {
						// 찾는 이름이 존재하는 경우.
						if (friendAry[i] != null && friendAry[i].equals(name)) {
							isExist = true;
							break; // 만약 이름데이터가 1000개라면 1000개 다 돌필요없이 동일이름 찾으면 그만찾게 break;
						}
					}
					// 추가 또는 취소 결정.
					if (isExist) {
						System.out.print("존재하는 이름입니다. 추가하겠습니까? 추가(1)/취소(2)>> ");
						menu = Integer.parseInt(scn.nextLine());
						if (menu == 2) {
							System.out.println("  😅취소했습니다😅\n");
							continue;
						}
					}
					// 배열에 추가.
					for (int i = 0; i < friendAry.length; i++) {
						// 빈공간(null)인지 확인 후 추가.
						if (friendAry[i] == null) {
							friendAry[i] = name;
							System.out.println("  ❤등록성공❤\n");
							break;
						}
					} // end of for.
					break;

				case 2: // 목록.
					// 입력값 출력.
					int no = 1;
					System.out.println("번호 이름");
					System.out.println("=============");
					for (int i = 0; i < friendAry.length; i++) {
						if (friendAry[i] != null) {
							System.out.printf(" %d) %s\n", no++, friendAry[i]);
						}
					}
					System.out.println();
					break;

				case 3: // 삭제.
					System.out.print("삭제할 친구 이름>> ");
					name = scn.nextLine();
					isExist = false; // 친구이름이 있는지를 확인여부.
					for (int i = 0; i < friendAry.length; i++) {
						if (friendAry[i] != null && friendAry[i].equals(name)) {
							friendAry[i] = null; // 삭제.
							System.out.println("  ⛏삭제성공⛏\n");
							isExist = true;
							break;
						}
					}
					// 이름을 못찾을 경우에 출력해주는 조건.
					if (!isExist) {
						System.out.println("  😅찾는 이름이 없습니다😅\n");
					}
					break;

				case 4: // 종료.
					System.out.println("프로그램을 종료합니다 Bye~~ ");
					run = false;
				}
			} // end of while.

			System.out.println("<< end of prog >>");
		}
		} // end of friendApp().


