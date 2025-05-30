package PrivateProject;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;



public class CarApp {
	boolean loginCheck() {
		Scanner scn1 = new Scanner(System.in);
		for (int i = 1; i <= 3; i++) {
			System.out.print("ID>>  ");
			String id = scn1.nextLine();
			System.out.print("PW>>  ");
			String pw = scn1.nextLine();
			if (!LoginExe.Login(id, pw)) {
				System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
				if (i == 3) {
					System.out.println("프로그램을 종료합니다.");
					return false;
				}
				continue;
			}
			return true;
		}
		System.out.println("프로그램을 종료합니다.");
		return false; // This is technically unreachable, but Java requires it.
	}// end loginCheck;

	public static void execute() {

		CarService cvc = new CarServiceDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("         ______              ");
			System.out.println("       /|_||_\\`.__          ");
			System.out.println("      (   _    _ _\\         ");
			System.out.println("      =`-(_)--(_)-'          ");

			System.out.println("╔══════════════════════════════════════════════╗");
			System.out.println("║         🚗🚗🚗🚗🚗 렌트 서비스 🚗🚗🚗🚗🚗         ║");
			System.out.println("╚══════════════════════════════════════════════╝");
			System.out.println();
			System.out.println("════════════════════  메뉴  ═════════════════════");
			System.out.println();
			System.out.println("          🔹 1. 출입 시스템    🔹 2. 등록");
			System.out.println("          🔹 3. 목록         🔹 4. 삭제");
			System.out.println("          🔹 5. 종료");
			System.out.println();
			System.out.println("════════════════════════════════════════════════");
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
							System.out.println("🤍🤍🤍 출차 완료 🤍🤍🤍");
						} else {
							System.out.println("☢☢☢ 출차 실패 ☢☢☢");
						}
						continue;

					}

					else if (submenu == 2) {
						// 입차
						System.out.print("입차할 차량번호>> ");
						String str = scn.nextLine();
						System.out.print("주행거리를 입력하세요>>");
						int dMile = Integer.parseInt(scn.nextLine());
						System.out.print("사고발생유무\ny or n으로 입력>>");
						String str2 = scn.nextLine();
						int accident = 0;
						if (str2.equals("y")) {
							accident = 1;
						} else if (str2.equals("n")) {
							accident = 0;
						}
						DriveList end = new DriveList();
						end.setNumPlate(str);
						end.setdMile(dMile);
						end.setAccident(accident);
						if (cvc.endDrive(end)) {
							System.out.println("🤍🤍🤍 입차 완료 🤍🤍🤍");
						} else {
							System.out.println("입차 실패");
						}
						continue;

					} else if (submenu == 3) {// 명부출력.
						System.out.println("차량번호------고객명---주행거리--출차여부--사고이력");
						List<DriveList> list = cvc.driveList();
						int page = 1;
						boolean run2 = true;
						while (run2) {
							try {
								int startp = (page - 1) * 5;
								int endp = page * 5;
								for (int i = startp; i < endp; i++) {
									System.out.printf("%9s %5s   %5d   %2s     %2d\n", list.get(i).numPlate,
											list.get(i).cName, list.get(i).getdMile(),
											(list.get(i).getIsExist() == 0 ? "출차" : "입차"), list.get(i).getAccident());

								}
							} catch (IndexOutOfBoundsException e) {
								System.out.println("더이상 페이지가 없습니다😛");
								System.out.println();
								
							}
							System.out.println();
							System.out.println("p.이전페이지 n.다음페이지 q.뒤로");
							String submenu2 = scn.nextLine();

							if (submenu2.equals("q")) {
								System.out.println("🚓");
								System.out.println("🚓");
								System.out.println("🚓");
								
							} else if (submenu2.equals("p")) {
								page--;
							} else if (submenu2.equals("n")) {
								page++;
							} else {
								System.out.println("다시입력하세요.");
								continue;
							}
							run2 = false;
						}
						break;
					}
				
				case 2:// 차량등록
					System.out.print("차종>>");
					String sort = scn.nextLine();
					System.out.print("크기>>");
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
					// SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
					int isExist = 1;
					Car car = new Car(sort, type, numPlate, price, mile, insurance, isExist, acc);
					if (cvc.addCar(car)) {
						System.out.println("🤍🤍🤍 등록 완료 🤍🤍🤍");
					} else {
						System.out.println("☢☢☢ 등록 실패 ☢☢☢");
					}
					break;
			case 3:// 차량 목록
					List<Car> list1 = cvc.carList();
					int page = 1;
					while (true) {
						System.out.println("╔═══════════════════════════════════╗");
						System.out.println("║ 🚌차종🚌  🚌 번호판  🚌  🚌 출차여부 🚌  ║");
						System.out.println("╚═══════════════════════════════════╝");
						try {
							int startp = (page - 1) * 5;
							int endp = page * 5;
							for (int i = startp; i < endp; i++) {
								System.out.printf("  %2s     %8s     %5s   \n", list1.get(i).getSort(), list1.get(i).getNumPlate(),
										(list1.get(i).getIsExist() == 0 ? "출차" : "입차"));
							}
						} catch (IndexOutOfBoundsException e) {
							System.out.println("---------------------------------");
							System.out.println("더이상 페이지가 없습니다😛");
							System.out.println();
							break;
						}
						System.out.println("╔═════════════════════════════════════╗");
						System.out.println("║ p.이전페이지 n.다음페이지 i.차량상세정보 q.뒤로 ║");
						System.out.println("╚═════════════════════════════════════╝");
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
							System.out.print("차번호>>");
							String numPlate1 = scn.nextLine();
							CarInfo cinfo = cvc.showInfo(numPlate1);
							DecimalFormat formatter = new DecimalFormat("###,###");
							String str2 = "☢ 차종 : %3s\n" + "☢ 크기 : %2s\n" + "☢ 번호판 : %9s\n" 
							            + "☢ 사고이력 : %d\n";
							System.out.printf(str2, cinfo.getSort(), cinfo.getType(), cinfo.getNumPlate(),
									 cinfo.getAccidentNum());
							System.out.println("☢ 총주행거리 : " + formatter.format(cinfo.getTotalMile()) +"Km");
							System.out.println("☢ 보험료 : " + formatter.format(cinfo.getInsurance()) + "원");
							System.out.println("☢ 현재가치 : " + formatter.format(cinfo.getPv()) + "원");
							System.out.println();
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
						System.out.println("🤍🤍🤍 삭제 완료 🤍🤍🤍");
					} else {
						System.out.println("☢☢☢ 삭제 실패 ☢☢☢");
					}
					break;
				case 5: //종료
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
