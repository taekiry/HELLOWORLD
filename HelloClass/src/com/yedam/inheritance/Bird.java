package com.yedam.inheritance;

/*
 * 부모클래스 : Animal(추상)
 */

public class Bird extends Animal {
	// 오버라이딩 안하면 Bird에 빨간줄.Bird must implement the inherited abstract method Animal.sound()
	
	//필드
	String kind;
	
	
	//메소드
	@Override
	public void sound() {	// 부모클래스의 sound()메소드 overriding
		System.out.println("짹짹");
	} 

}
