package com.yedam.ref;
//실행클래스
public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20; int b = 30;
		
		//sum의 기능활용
		Calculator c1 = new Calculator();//static 없으면 인스턴스 필요
		c1.sum(a, b); 		  //노란밑줄 -> 정적메소드 방식이 아니라서
		
		Calculator.sum(a, b); //static 지정했을때 (정적메소드 호출방식)
		printStar();		  //static void printStar가 아니어서
		
//		CalculatorExe prt = new CalculatorExe();
//		prt.printStar();
		
	}
		
	static void printStar() {
		System.out.println("*");
	}
	
}// end CalculatorExe