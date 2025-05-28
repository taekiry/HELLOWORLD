package PrivateProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CarApp {
	public static void execute() {
		CarService cvc = new CarServiceDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {

			System.out.println("-----------------렌트서비스-----------------");
			System.out.println("<메뉴>");
			System.out.println("1.출입시스템 2.등록 3.목록 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
		
			case 1://출입시스템
				System.out.println("1.출차 2.입차 3.출입명부");
				int submenu = Integer.parseInt(scn.nextLine());
				switch (submenu) {
				case 1://출차
				case 2://입차
				case 3://명부
				}
			case 2://차량등록
				System.out.print("차종>>");
				String sort = scn.nextLine();
				System.out.print("대소형>>");
				String type = scn.nextLine();
				System.out.print("번호판>>");
				String numPlate = scn.nextLine();
				System.out.print("가격>>");
				int price = Integer.parseInt(scn.nextLine());
				System.out.print("주행거리>>");
				int mile = Integer.parseInt(scn.nextLine());
				System.out.print("보험만료일>>");
				String insurance = scn.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

				Car car = new Car(sort, type, numPlate, price, mile, insurance);
				if (cvc.addCar(car)) {
					System.out.println("등록 완료.");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 3://차량 목록
				System.out.println("차종    번호판       출차여부");

				List<Car> list1 = cvc.carList();
				for (Car car2 : list1) {
					System.out.printf("%3s %10s %5s\n",car2.getSort(),car2.getNumPlate()
							,(car2.isExist==0?"출차":"입차"));
				}

				break;
			case 4://삭제
				System.out.print("삭제할 차의 번호>>");
				numPlate = scn.nextLine();
				String numP = numPlate.substring(numPlate.length() - 4);
				if (cvc.removeCar(numP)) {
					System.out.println("삭제 완료.");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5://종료
				run = false;
				break;
			}

		} // end while
		System.out.println("프로그램을 종료합니다.");
	}// end main

}// end CarApp
