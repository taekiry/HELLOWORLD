package com.yedam.board;

/*
 * 게시판.
 * Board : (필드) 글번호, 제목, 내용, 작성자.
 * BoardExe: 추가, 수정, 삭제, 목록
 * BoardApp: Main 메소드 실행클래스.
 */

import java.util.Scanner;

public class BoardExe { //기본 메소드들을 저장해뒀다가 App class에서 사용
	//필드
	private Board[] boards; //boards에 여러가지 담아놓고 쓰기위해 Board 타입 배열로
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;  	// 초기인덱스값이 2로 되어야 안덮어쓰지 
	
	//생성자
	public BoardExe() { //배열이 필드일 경우 생성자안에 필드의 크기 지정해야되나?
		boards = new Board[100]; //boards라는 곳에 100개짜리Board 타입 배열을 할당
		boards[0] = new Board(10,"날씨가 좋습니다","기온이 30도가 넘는데도","홍길동");
		boards[1] = new Board(11,"집이 좋습니다","머리가 아파오기때문에","김민규");
	}
	
	
	//메소드
	
	void execute() {
		
		boolean run = true;
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
				//modBoard();
				
			case 3: //삭제/
				
			case 4: //목록.
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
	
	
	//추가 메소드
	//"글 번호를 입력하세요>> "1
	//"제목을 입력하세요>> " 오늘은 덥네요.
	//"내용을 입력하세요>> " 오늘 기온이 30도가 넘습니다.
	//"작성자를 입력하세요>> " 홍길동
	//"추가성공" / "추가실패"메세지출력.
	
	void addBoard() {
		System.out.print("글번호를 입력하세요>> ");
		int no = Integer.parseInt(scn.nextLine());
		
		System.out.print("제목을 입력하세요>> ");
		String title = scn.nextLine();
		
		System.out.print("내용을 입력하세요>> ");
		String content = scn.nextLine();
		
		System.out.print("작성자를 입력하세요>> ");
		String writer = scn.nextLine();
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
	
	//** 등록된 글이 없습니다 **
	void boardList() {
		System.out.println("글번호     제목            작성자");
		System.out.println("============================");
		for(int i = 0 ; i < boards.length; i++) {
			if(boards[i] != null) {
				boards[i].showInfo();
			}
		}
		System.out.println("---------------------------");  
		System.out.println("상세보기: 글번호입력, 메뉴로 이동(q)");
		System.out.println("---------------------------");
		
		String str = scn.nextLine();
		
		//메뉴로 이동 or 상세보기
		if(str.equals("q")) {
			return;    		//boardList에서 나오면 break -> while문 다시 실행
		} else {
			int no = Integer.parseInt(str);
			//배열에서 글번호 조회
			for(int i = 0; i < boards.length; i++) {
				if(boards[i] != null && boards[i].getBoardNo() == no) {
					boards[i].showAllInfo();
				}
			}
		}
		System.out.println();
	}
	
	
	
//	void modBoard() {
//		System.out.print("수정할 글의 번호를 입력>> ");
//		int no = Integer.parseInt(scn.nextLine());
//		if()
//	}
}//end BoardExe
