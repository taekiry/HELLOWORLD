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

			System.out.println("🚗🚗🚗🚗🚗🚗🚗🚗렌트서비스🚗🚗🚗🚗🚗🚗🚗🚗");
			System.out.println("<메뉴>");
			System.out.println("1.출입시스템 2.등록 3.목록 4.삭제 5.고객관리 6.종료");
			try {
				int menu = Integer.parseInt(scn.nextLine());
				switch (menu) {

				case 1:// 출입시스템
					System.out.println("1.출차 2.입차 3.출입명부");
					int submenu = Integer.parseInt(scn.nextLine());
					if (submenu == 1) {
						// 출차
						System.out.print("출차할 차량번호>> ");
						String str = scn.nextLine();
						System.out.print("고객 성함>> ");
						String cname = scn.nextLine();
						DriveList dlt = new DriveList();
						dlt.setNumPlate(str);
						dlt.setcName(cname);
						if (cvc.startDrive(dlt)) {
							System.out.println("출차 완료");
						} else {
							System.out.println("출차 실패");
						}
						continue;

					}

					else if (submenu == 2) {
						// 입차
						System.out.print("입차할 차량번호>> ");
						String str = scn.nextLine();
						System.out.print("주행거리를 입력하세요>>");
						int dMile = Integer.parseInt(scn.nextLine());
						System.out.println("사고발생유무");
						int accident = Integer.parseInt(scn.nextLine());
						int isExist = 1;
						DriveList end = new DriveList(str, dMile, isExist, accident);
						if (cvc.endDrive(end)) {
							System.out.println("입차 완료");
						} else {
							System.out.println("입차 실패");
						}
						continue;
					} else if (submenu == 3) {// 명부출력.
						System.out.println("차량번호------고객명---주행거리--출차여부--사고이력");
						List<DriveList> list = cvc.driveList();
						int page = 1;
						while (true) {
							try {
								int startp = (page - 1) * 5;
								int endp = page * 5;
								for (int i = startp; i < endp; i++) {
									System.out.printf("%9s %5s   %5d   %2s     %2d\n", list.get(i).numPlate,
											list.get(i).cName,
											list.get(i).getdMile(),
											(list.get(i).getIsExist() == 0 ? "출차" : "입차"),
											list.get(i).getAccident());

								}
							} catch (IndexOutOfBoundsException e) {
								System.out.println("더이상 페이지가 없습니다😛");
								System.out.println();
								break;
							}
							System.out.println();
							System.out.println("p.이전페이지 n.다음페이지 i.차량상세정보 q.뒤로");
							break;
						}
					}

				case 2:// 차량등록
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
					System.out.print("사고이력>> ");
					int acc = Integer.parseInt(scn.nextLine());
					SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

					Car car = new Car(sort, type, numPlate, price, mile, insurance, acc);
					if (cvc.addCar(car)) {
						System.out.println("등록 완료.");
					} else {
						System.out.println("등록 실패");
					}
					break;

				case 3:// 차량 목록
					List<Car> list1 = cvc.carList();
					int page = 1;
					while (true) {
						System.out.println("차종-----번호판-------출차여부");
						try {
							int startp = (page - 1) * 5;
							int endp = page * 5;
							for (int i = startp; i < endp; i++) {
								System.out.printf("%3s %10s %5s\n", list1.get(i).getSort(), list1.get(i).getNumPlate(),
										(list1.get(i).getIsExist() == 0 ? "출차" : "입차"));
							}
						} catch (IndexOutOfBoundsException e) {
							System.out.println("더이상 페이지가 없습니다😛");
							System.out.println();
							break;
						}
						System.out.println();
						System.out.println("p.이전페이지 n.다음페이지 i.차량상세정보 q.뒤로");
						String submenu2 = scn.nextLine();

						if (submenu2.equals("q")) {
							System.out.println("🚓");
							System.out.println("🚓");
							System.out.println("🚓");
							break;
						} else if (submenu2.equals("p")) {
							page--;
						} else if (submenu2.equals("n")) {
							page++;
						} else if (submenu2.equals("i")) {
							System.out.println("차량번호>>");
							int num = Integer.parseInt(scn.nextLine());

						} else {
							System.out.println("다시입력하세요.");
							continue;
						}
						continue;
					} // end while.
					break;
				case 4:// 삭제
					System.out.print("삭제할 차의 번호>>");
					numPlate = scn.nextLine();
					if (cvc.removeCar(numPlate)) {
						System.out.println("삭제 완료.");
					} else {
						System.out.println("삭제 실패");
					}
					break;
				case 5: // 고객관리

				case 6:// 종료
					run = false;
					break;
				}

			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			}

		} // end while
		System.out.println("프로그램을 종료합니다.");

	}// end execute

}// end CarApp
