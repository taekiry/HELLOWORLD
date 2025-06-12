package com.yedam.inheritance;

public class AnimalExe {

	public static void main(String[] args) {
		 
		// 추상클래스는 인스턴스 생성 불가!
		//Animal aniaml = new Animal(); Cannot instantiate the type Animal
		
		Animal a1 = new Bird();
		a1.breathe();
		a1.sound();
		
		a1 = new Fish();
		a1.breathe();
		a1.sound();
		// 같은 메소드지만 다른 인스턴스 사용 -> 메소드의 다형성 
	}
}// end AnimalExe
