package reviewClass;

/*
 * 게시판.
 * review : (필드) 글번호, 제목, 내용, 작성자.
 * review4Exe: 추가, 수정, 삭제, 목록
 * review4App: Main 메소드 실행클래스.
 */

public class Review4App {
	
	public static void main(String[] args) {
		
		Review4Exe exe = new Review4Exe();
		exe.execute();
		
	}

}//end review4App
