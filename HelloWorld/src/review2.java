import java.util.Scanner;

public class review2 {
	public static void main(String[] args) {
		// test01();
		// test02();
		test03();
	} // end main

	public static void test01() {

		
		int randomValue = (int) (Math.random() * 1000) + 1;

		System.out.println(randomValue);
		int num1 = 0;
		while (true) {
			System.out.println("1~1000 사이의 숫자를 입력하세요");
			int number = Integer.parseInt(scn.nextLine());
			if (randomValue < number) {
				System.out.println("더 작습니다");
				num1++;
			} else if (randomValue > number) {
				System.out.println("더 큽니다");
				num1++;
			} else {
				num1++;
				System.out.println("정답입니다");
				break;
			}
		} // end while
		System.out.printf("시도회수는: %d,정답은 %d입니다.", num1, randomValue);
	}// end test

	public static void test02() {
		//

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("가위(1),바위(2),보(3),종료(4)");
			int com = (int) (Math.random() * 3) + 1;
			System.out.println(com);
			int me = Integer.parseInt(scn.nextLine());
			int diff = me - com;
			if (diff == 0) {
				System.out.println("비겼습니다.");
			} else if (diff == -2 || diff == 1) {
				System.out.println("이겼습니다.");
			} else if (diff == 2 || diff == -1) {
				System.out.println("졌습니다.");
			}
			if (me == 4) {
				System.out.println("종료합니다.");
				break;
			}
		} // end while
	}// end test02

	public static void test03() {
		System.out.println(" Mon Tue Wed Thr Fri Sat Sun");
		//빈공간
		Scanner scn = new Scanner(System.in);
		
		for (int i = 1; i<= 4; i++ ) {
			System.out.printf("%4s"," ");
		}
		
		for (int day = 1; day <= 31; day++) {
			System.out.printf("%4d", day);
			if (day % 7 == 3) {
				System.out.println();
			}

		}

	}// end test03

}// end class
