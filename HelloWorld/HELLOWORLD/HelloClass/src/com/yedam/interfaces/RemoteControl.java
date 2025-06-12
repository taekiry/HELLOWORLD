package com.yedam.interfaces;
/*
 * 인터페이스 : 필드(상수),메소드(추상)
 */
public interface RemoteControl {
	
	//필드 : 상수는 모두 대문자, 두 단어일 경우 _ 사용, final 없어도 상수취급
	public int MAX_VOLUME = 10;	
	
	//추상 메소드 (abstract 없어도 추상)
	public abstract void turnOn();
	public void turnOff();
	
}
