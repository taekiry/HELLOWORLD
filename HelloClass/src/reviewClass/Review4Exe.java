package reviewClass;

import java.util.Scanner;


/*
 * 게시판.
 * Board : (필드) 글번호, 제목, 내용, 작성자.
 * BoardExe: 추가, 수정, 삭제, 목록 , 종료
 * BoardApp: Main 메소드 실행클래스.
 */

public class Review4Exe {
	//필드
	private Scanner scn = new Scanner(System.in);
	private Review4[] books; 
	private int cnt = 0;
	
	//static Student[] scores = null; TodoExe와 다른방식 왜?
	// 그 밑에 scores = new Student[studentNum]으로 개수가 지정됨. 
	
	//생성자 
	public Review4Exe(){
		books = new Review4[100]; 
		//위에 books가 null이어서 공간지정해야되는데 그냥 기본생성자 안에 넣엇음. Review4[] books = new Review[100]; 해도됨.
		//만약 riview4exe 생성자 안에 넣지않으면 execute 메서드에 넣어야한다. 
		//실행할때마다 공간이 100개 생겨버림;
	}
		
	
	
	void execute () { //Review4Exe는 execute라는 메소드를 갖고있음.
		
		
		boolean run = true;
		
		while(run) {
			
			System.out.println("----------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("----------------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
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
			
		}//end while
		
		System.out.println("***프로그램 종료***");
		
		
	} //end execute
	
	void App1 () {
		int storyNo = userNo("글번호 ");
		String title1 = userMsg("제목 ");
		String content1 = userMsg("내용 ");
		String writer1 = userMsg("작성자" );
		
		Review4 board = new Review4(storyNo,title1,content1,writer1);
		books[cnt++] = board;  //board라는 보따리를 review4 클래스 배열인 books에 하나씩 할당하겠다.
	}
	
	void App2() {
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
		
		System.out.println("글번호      제목     작성자");
		System.out.println("======================");
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null ) {
				System.out.printf();
			}
		}
		
		
	}//end of App2
	
	
	//String 값 반환 메소드
		String userMsg(String msg) {
		System.out.println(msg + ">> ");
		return scn.nextLine();
	}
	//Int값 반환 메소드
		int userNo(String msg) {
			System.out.println(msg + ">> ");
			return Integer.parseInt(scn.nextLine());
		}
	
}//end Reiview4Exe