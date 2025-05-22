package com.yedam.inheritance;

public class Fish extends Animal {
	//필드
	String kind;
	
	
	//메소드 Animal에 breathe도 있지만 강제아니니까.
	@Override
	public void sound() {
		System.out.println("뻐끔뻐끔");
	}
	
}
