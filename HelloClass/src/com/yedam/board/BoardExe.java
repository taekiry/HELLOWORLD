package com.yedam.board;

/*
 * 추가(addBoard)
 * 수정(modifyBoard) - 글번호로 조회, 바뀔내용, 바뀔제목
 * 삭제(removeBoard) - 글번호 조회 -> 삭제/삭제할 글이 없습니다.
 * 목록(boardList)
 * 조회기능(글번호 -> 글(보드타입)반환) getBoard
 * 순번부여(nextSequence) -> 현재글번호 + 1
 */

import java.util.Scanner;

public class BoardExe { //기본 메소드들을 저장해뒀다가 App class에서 사용
	//필드
	private Board[] boards; //boards에 여러가지 담아놓고 쓰기위해 Board 타입 배열로
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;  	// 초기인덱스값이 2로 되어야 안덮어쓰지 
	
	//생성자
	public BoardExe() { //배열이 필드일 경우 생성자안에 필드의 크기 지정해야되나 -> 초기값 설정한거임
		boards = new Board[100]; // 기본생성자 안에 크기지정한것일 뿐 위에 private Board[] boards = new Board[100]
		boards[0] = new Board(10,"날씨가 좋습니다","기온이 30도가 넘는데도","홍길동");
		boards[1] = new Board(11,"집이 [11]좋습니다","머리가 아파오기때문에","김민규");
		boards[2] = new Board(12,"집이 [12]좋습니다","머리가 아파오기때문에","김민규");
		boards[3] = new Board(13,"집이 [13]좋습니다","머리가 아파오기때문에","김민규");
		boards[4] = new Board(14,"집이 [14]좋습니다","머리가 아파오기때문에","김민규");
		boards[5] = new Board(15,"집이 [15]좋습니다","머리가 아파오기때문에","김민규");
		boards[6] = new Board(16,"집이 [16]좋습니다","머리가 아파오기때문에","김민규");
		boards[7] = new Board(17,"집이 [17]좋습니다","머리가 아파오기때문에","김민규");
		boards[8] = new Board(18,"집이 [18]좋습니다","머리가 아파오기때문에","김민규");
		boards[9] = new Board(19,"집이 [19]좋습니다","머리가 아파오기때문에","김민규");
		boards[10] = new Board(20,"집이 [20]좋습니다","머리가 아파오기때문에","김민규");
	}
	/*
	 * 1page : [0]~[4] => (page-1) * 5 <= x < page * 5
	 * 2page : [5]~[9]
	 * ....
	 */
	
	//메소드
	
	void execute() {
		
		
		//verify ID,PW
		//아이디 입력
		//비밀번호 입력
		boolean run = true;
		
		for(int i = 0; i < 3; i++) {
			String id = userMessage("아이디를 입력하세요");
			String pw = userMessage("비밀번호를 입력하세요");
			
			if(UserExe.login(id, pw)) {
				System.out.println("로그인 성공!\n");
				run = true;
				break;
			} 
			run = false;
		}	
		
		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("----------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			
			switch(selectNo) {
			case 1: //추가
				addBoard(); 
				break;
				
			case 2: //수정.
				modifyBoard();
				break;
				
			case 3: //삭제/
				removeBoard();
				break;
				
			case 4: //목록.
//				sort();
				boardList();
				break;
			case 5: //종료.
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
				
			}// end switch
			
			
		}//end while
		System.out.println("종료합니다.");
	
	}//end execute
	
	
	//1. 추가 메소드
	//"글 번호를 입력하세요>> "1
	//"제목을 입력하세요>> " 오늘은 덥네요.
	//"내용을 입력하세요>> " 오늘 기온이 30도가 넘습니다.
	//"작성자를 입력하세요>> " 홍길동
	//"추가성공" / "추가실패"메세지출력.
	
	void addBoard() { 
		
//		int no = userMenu("글번호를 입력하세요");
		int no = nextSequence(); //입력방식x 자동으로 글번호가 다음번호 나오게
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");
		
		// Board 인스턴스 선언하고 값을 지정.
		Board board = new Board(no, title, content, writer);
		
		//배열에 저장/
		boards[bno++] = board;   //보드의 값들을 보드즈[0]부터 할당
		System.out.println("추가성공");
	}
	
	
	
	// 목록 기능
	//글번호     제목    작성자  (원래 내용은 상세보기란에 따로 있어야함)
	//====================
	//  1  날씨가 좋아요  홍길동
	//  2  클래스 멋집!  김민규
	//  3  자바어려움    박석민
	//  4  그래도 열심히! 김민규
	//---------------------------
	//상세보기: 글번호입력, 메뉴로 이동(q)
	//---------------------------
	
	//** 등록된 글이 없습니다 ** 4.목록
	void boardList() {
		//sort();
		int page = 1;
		
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5; // 페이지안에 5개항목 넣기
			System.out.println("글번호     제목            작성자");
			System.out.println("============================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			System.out.println("------------------------------------------------");
			System.out.println("상세보기: 다음페이지(n),이전페이지(n),글번호입력, 메뉴로 이동(q)");
			System.out.println("------------------------------------------------");

			String str = scn.nextLine();

			// 메뉴로 이동 or 상세보기
			if (str.equals("q")) {
				break; // boardList에서 나오면 break -> while문 다시 실행 break;쓰면 오류
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("n")){
				page--;
			} else {
				int no = Integer.parseInt(str);
				// 배열에서 글번호 조회
				Board sboard = getBoard(no); // searchBoard
				if (sboard == null) {
					System.out.println("조회결과 없음");
					return;
				}
				sboard.showAllInfo();
			}
		} // end while
		System.out.println();
	}//end boardList
	
	//2. 수정 메소드
	void modifyBoard() {
		int bno = userMenu("수정할 글번호 입력");
		Board result = getBoard(bno);
		if(result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;//메소드 종료
		}
		
		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용을 입력");
		
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료.");
		
	}
	
	//3. 삭제 메소드 //이건 왜 안될까 
	void removeBoard() {
		int bno = userMenu("삭제할 글 번호:");
//		Board result = getBoard(bno);
//		if(result == null) {
//			System.out.println("삭제할 글이 없습니다");
//			return;
//		} else {
			for(int i = 0; i < boards.length; i++) {
				if(boards[i] != null && boards[i].getBoardNo() == bno) {
					boards[i] = null;
					System.out.println("삭제되었습니다.");
					return;
				} else {
					System.out.println("삭제할 글이 없습니다");
					return;
			}
//			System.out.println("삭제되었습니다.");
		}
	} // end of removeBoard
	
	
	
	//배열에서 글번호 조회 -> 글정보 Board 반환 (getBoard;단건조회)
	Board getBoard(int bno) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; //for문 다찾아봐도 없으면 null을 리턴.
	}	
	
	//사용자의 입력값을 반환하는 메소드
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	}
	
	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	}
	
	
	//글번호 순번 생성 nextSequence
	
	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if(boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		} return max + 1;
	} 
	
	//교수님의 정렬(sort) 메소드
	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.
	

}//end class BoardExe
