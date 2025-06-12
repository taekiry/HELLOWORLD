package reviewClass;

import java.util.Scanner;

import com.yedam.board.Board;

/*
 * 게시판.
 * Board : (필드) 글번호, 제목, 내용, 작성자.
 * BoardExe: 추가, 수정, 삭제, 목록 , 종료
 * BoardApp: Main 메소드 실행클래스.
 */

public class Review4Exe {
	// 필드
	private Scanner scn = new Scanner(System.in);
	private Review4[] books;
	private int cnt = 0;

	// static Student[] scores = null; TodoExe와 다른방식 왜?
	// 그 밑에 scores = new Student[studentNum]으로 개수가 지정됨.

	// 생성자
	public Review4Exe() {
		books = new Review4[100];
		// 기본생성자 안에 크기지정한것일 뿐 위에 private Review4[] books = new Review4[100]
		books[0] = new Review4(10, "날씨가 좋습니다", "기온이 30도가 넘는데도", "홍길동");
		books[1] = new Review4(11, "집이 [11]좋습니다", "머리가 아파오기때문에", "김민규");
		books[2] = new Review4(12, "집이 [12]좋습니다", "머리가 아파오기때문에", "김민규");
		books[3] = new Review4(13, "집이 [13]좋습니다", "머리가 아파오기때문에", "김민규");
		books[4] = new Review4(14, "집이 [14]좋습니다", "머리가 아파오기때문에", "김민규");
		books[5] = new Review4(15, "집이 [15]좋습니다", "머리가 아파오기때문에", "김민규");
		books[6] = new Review4(16, "집이 [16]좋습니다", "머리가 아파오기때문에", "김민규");
		books[7] = new Review4(17, "집이 [17]좋습니다", "머리가 아파오기때문에", "김민규");
		books[8] = new Review4(18, "집이 [18]좋습니다", "머리가 아파오기때문에", "김민규");
		books[9] = new Review4(19, "집이 [19]좋습니다", "머리가 아파오기때문에", "김민규");
		books[10] = new Review4(20, "집이 [20]좋습니다", "머리가 아파오기때문에", "김민규");

		// 위에 books가 null이어서 공간지정해야되는데 그냥 기본생성자 안에 넣엇음. Review4[] books = new
		// Review[100]; 해도됨.
		// 만약 riview4exe 생성자 안에 넣지않으면 execute 메서드에 넣어야한다.
		// 실행할때마다 공간이 100개 생겨버림;
	}

	void execute() { // Review4Exe는 execute라는 메소드를 갖고있음.

		boolean run = true;

		while (run) {

			System.out.println("----------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("----------------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				App1();
				break;
			case 2:

			case 3:

			case 4:
				App2();
				break;

			case 5:
				run = false;
				break;
			}

		} // end while

		System.out.println("***프로그램 종료***");

	} // end execute

	void App1() {
		int storyNo = userNo("글번호 ");
		String title1 = userMsg("제목 ");
		String content1 = userMsg("내용 ");
		String writer1 = userMsg("작성자");
		int cnt = 0;
		Review4 board = new Review4(storyNo, title1, content1, writer1);
		books[cnt++] = board; // board라는 보따리를 review4 클래스 배열인 books에 하나씩 할당하겠다.
	}

	void App2() {
		// 목록 기능
		// 글번호 제목 작성자 (원래 내용은 상세보기란에 따로 있어야함)
		// ====================
		// 1 날씨가 좋아요 홍길동
		// 2 클래스 멋집! 김민규
		// 3 자바어려움 박석민
		// 4 그래도 열심히! 김민규
		// ---------------------------
		// 상세보기: 글번호입력, 메뉴로 이동(q)
		// ---------------------------

		// ** 등록된 글이 없습니다 ** 4.목록
		int page = 1;
		while (true) {
			int start = (page - 1) * 5;
			int end = (page * 5);
			System.out.println("글번호      제목       작성자");
			System.out.println("=========================");
			for (int i = start; i < end; i++) {
				if (books[i] != null) {
					books[i].showInfo();
				}
			}
			System.out.println("-------------------------------------------------------");
			System.out.println("상세보기 : 글번호 입력, 다음페이지(n), 이전페이지(p), 메뉴로 이동(q)");
			System.out.println("-------------------------------------------------------");
			String quit = scn.nextLine();
			

			if (quit.equals("q")) {
				break;
			}
			else if (quit.equals("n")) {
				page++;
			}
			else if (quit.equals("p")) {
				page--;
			}
			else {
				int no = Integer.parseInt(quit);
				Review4 rvw = getBooksNo(no);
				if( rvw == null) {
					System.out.println("찾는 글이 없습니다.");
					return;
				}
				rvw.showInfoAll();
			}

		} System.out.println();

	}// end of App2

	// String 값 반환 메소드
	String userMsg(String msg) {
		System.out.println(msg + ">> ");
		return scn.nextLine();
	}

	// Int값 반환 메소드
	int userNo(String msg) {
		System.out.println(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}
	
	public Review4 getBooksNo(int no) { //Review4 타입으로 만들어야 books[i]값이나 null을 리턴한다.
		for(int i = 0; i < books.length; i++) { //books.length 값 받아와야되서 exe파일에 만드신
			if(books[i] != null && books[i].getStoryNo() == no) {
				return books[i];
			}
		}return null;
	}
	// showInfo

}// end Reiview4Exe