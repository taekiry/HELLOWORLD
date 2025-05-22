package com.yedam.inheritance;
/*
 * 추상 클래스 (abstact class) : 인스턴스 생성불가, 추상메소드 생성가능
 * 
 * 자식 클래스 : Bird, Fish
 */
public abstract class Animal {
	
	//필드
	String kind;
	
	//생성자 - 기본
	
	//메소드
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	//추상 메소드 : 자식 클래스에서 반드시 오버라이딩 해야함.
	public abstract void sound(); // 선언만 가능 기능이없음.
	
	
	
} // end class Animal;

