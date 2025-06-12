package com.yedam.interfaces;

/*
 * 클래스 Television은 RemoteControl 인터페이스를 상속(X) 구현(O)하는 클래스
 */
public class Television implements RemoteControl {
		//반드시 RemoteControl의 메소드 구현해야함.
	@Override
	public void turnOn() {
		System.out.println("텔레비전을 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("텔레비전을 끕니다.");
		
	}
	
}
