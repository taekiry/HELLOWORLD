package com.yedam.board;

import java.util.Scanner;

/*
 * User: (필드) 아이디, 비밀번호, 이름 
 * 로그인 -> 등록되어있는 사용자만 boardExe 실행되게끔
 */
class User{
	//필드
	private String userId;
	private String passWd;
	private String userName;
	
	//전체 생성자
	public User(String userId, String passWd, String userName) {
		
		this.userId = userId;
		this.passWd = passWd;
		this.userName = userName;
	}

	//getter
	public String getUserId() {
		return userId;
	}

	public String getPassWd() {
		return passWd;
	}

	public String getUserName() {
		return userName;
	}
}//end User


public class UserExe {
	
	static User[] users = { //user 데이터 타입의 배열을 선언해야해서 
			new User("holy","1111","김영광"),
			new User("cutie","2222","홍예쁨"),
			new User("guest","3333","밤손님")
	};
	
	static boolean login(String name, String passwd) {
		//위에서 값받아와서 있으면 true 없으면 false.
		for(int i = 0; i < users.length; i++) {
			if(users[i].getUserId().equals(name) && users[i].getPassWd().equals(passwd)) {
				return true;
			}
		}
		System.out.println("로그인 실패: 일치하지 않습니다.\n");
		return false;
	}
	
}//end UserExe
