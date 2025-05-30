package PrivateProject;

import java.util.Scanner;

class Login {

	String id;
	String pw;
	String userName;

	public Login(String id, String pw, String userName) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}//end Login
public class LoginExe {

	static Login[] users = { new Login("xozlfl789", "xodhks25", "사장"), 
							 new Login("admin", "admin12", "서버관리자")

	};

	public static boolean Login(String id, String pw) {
		for (int i = 0; i < users.length; i++) {
			if (id.equals(users[i].getId()) && pw.equals(users[i].getPw())) {
				return true;
			}
		}
		return false;
	}
	
}// end LoginExe

