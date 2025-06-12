import java.util.Scanner;

public class review3_arry {
	public static void main(String[] args) {
	
		test01();
	}//end main
	
	public static void test01() {
		String[] friendAry = new String[10]; 
	    /*String[] friendAry = null; 숫자 입력받을시 null은 알겠는데 문자 지정시는 null사용할수없나?*/
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) {
				System.out.println("선택>> ");
				String name = scn.nextLine();
				for(int i = 0; i < friendAry.length; i++) {
					if(friendAry[i] == null) {
						friendAry[i]= name;
						break;
					} else { 
						if(name.equals(friendAry[i])) {
						System.out.println("추가하시겠습니까? 1.추가 2.취소");
						int subMenu = Integer.parseInt(scn.nextLine());
							if( subMenu == 2 ) {
								System.out.println("취소했습니다.");
								break;
							}
						}
					}	
				}
			} else if (menu == 2) {
				for(int i = 0; i < friendAry.length; i++) {
					if(friendAry[i] != null) {
						System.out.printf("%d번째 친구의 이름은 : %s\n",i+1,friendAry[i]);
					} 
				}
				
			} else if (menu == 3) {
				System.out.println("삭제하시겠습니까? 1.전체삭제 2.부분삭제");
				String[] temp = new String[friendAry.length];
				int subMenu2 = Integer.parseInt(scn.nextLine());
				if (subMenu2 == 1) {
					for (int i = 0; i < friendAry.length; i++) {
					    friendAry[i] = null;
					}
					System.out.println("전체 삭제되었습니다.");
					
				} else if (subMenu2 == 2) {
					System.out.print("삭제할이름은> ");
					String delName = scn.nextLine();
					for(int i = 0; i < friendAry.length; i++) {
						if(friendAry[i] != null && delName.equals(friendAry[i])){
							friendAry[i] = null;
						}
					}
				}
			} else if (menu == 4) {
				System.out.println("종료합니다.");
				run = false;
			}
		}//end while
	}//end test01
//	for(int i = 0; i < friendAry.length; i++) {
//		if (friendAry != null) {
//			friendAry[i] = temp[i];
//			System.out.println("전체삭제되었습니다.");
//		}
//	}

}//end class
