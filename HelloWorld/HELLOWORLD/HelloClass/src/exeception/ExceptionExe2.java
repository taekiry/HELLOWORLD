package exeception;

import java.util.NoSuchElementException; // java.lang에 있던거라 임포트 했음.
import java.util.Scanner;

public class ExceptionExe2 {

	public static void main(String[] args) {

		/* Sample 예외들 */
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) { 
			System.out.println("1.메뉴 2.종료");
			System.out.println("선택>> ");
			int menu = 0;
			while (true) { // 적절한 값을 선택할때까지 무한반복.
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException | NoSuchElementException e) {  //NoSuchElementException 스캐너가 finally에서 닫겻더니 위에서 다시 scn쓸수없어서 발생했었음
					System.out.println("메뉴를 다시선택하세요.");
					System.out.println("1.메뉴 2.종료");
					scn.nextLine();
					continue;
				} 
				break;//정상적인실행시 while문 밖으로.
			}

			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
				break;
			default:
				System.out.println("없는 메뉴를 선택해서 종료합니다.");
			}

		} // end while
		System.out.println("end of prog.");
		scn.close();
	}// end main

	public static void 백업() {
		// NullPointerException
		// NumberFormatException
		// ClassCastException (CCE)
		// ArrayIndexOutOfBoundsException (AOE)

		Scanner scn = new Scanner(System.in);

		String str = scn.nextLine();
		try {
			System.out.println(str.toString()); // Exception in thread "main" java.lang.NullPointerException:
			int num = Integer.parseInt("a");

		} catch (NullPointerException | NumberFormatException e) { // Cannot invoke "String.toString()" because "str" is
																	// null
			System.out.println("Null 값을 참조.");
//		} catch(NumberFormatException e) {
//			System.out.println("a는 숫자가아니야");
		} finally { // 정상실행, 예외발생 반드시 실행해주는 코드.
			//scn.close(); // 리소스를 환원.(메모리관리프로그램에 알려줌) 안닫으면 Resource leak: 'scn' is never closed
		}

		System.out.println("end of 백업prog.");
	}

}// end ExceptionExe2
