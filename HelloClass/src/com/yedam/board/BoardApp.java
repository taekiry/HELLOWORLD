package com.yedam.board;

/*
 * 게시판.
 * Board : (필드) 글번호, 제목, 내용, 작성자.
 * BoardExe: 추가, 수정, 삭제, 목록
 * BoardApp: Main 메소드 실행클래스.
 */

public class BoardApp {
	
	public static void main(String[] args) {
	
		BoardExe exe = new BoardExe();
		exe.execute();
		
	}//end main
	
}//end BoardApp
