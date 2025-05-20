package reviewClass;

import java.util.Scanner;


/*
 * 게시판.
 * Board : (필드) 글번호, 제목, 내용, 작성자.
 * BoardExe: 추가, 수정, 삭제, 목록
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
		//위에 books가 null이어서 생성자로 공간을 만들어놔야함
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
				
			case 5:
				run = false;
				break;
			}
			
		}//end while
		
		System.out.println("***프로그램 종료***");
		
		
	} //end execute
	
	void App1 () {
		System.out.println("글번호 : ");
		int storyNo = Integer.parseInt(scn.nextLine());
		
		System.out.print("제목 : ");
		String title1 = scn.nextLine();

		System.out.print("내용 : ");
		String content1 = scn.nextLine();
		
		System.out.print("작성자 : ");
		String writer1 = scn.nextLine();
		
		Review4 board = new Review4(storyNo,title1,content1,writer1);
		
		books[cnt++] = board;  //board라는 보따리를 review4 클래스 배열인 books에 하나씩 할당하겠다.
	}
	
	
	
}//end Reiview4Exe