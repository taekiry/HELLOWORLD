package com.yedam.inheritance;
/*
 * 부모: CellPhone
 *     -기능: 전원 켜기, 전원 끄기, 통화        // 볼륨 Up, 볼륨 Down,
 *     - Model명, Color
 * 자식 : SmartPhone
 *     -기능: 부모 기능 + Tv 보기
 */
public class CellPhone {
	String model;
	String color;
	
	public CellPhone(String model, String color) {//왜 에러날까 교수님문제 -->생성자는 상속 불가. 부모 변수로 자식 인스턴스 만들때 부모의 기본생성자 호출.
		this.model = model;
		this.color = color;
	}
	public CellPhone() {
		// TODO Auto-generated constructor stub
	}
	void powerOn() {
		System.out.println("전원을 켜기");
	}
	
	void powerOff() {
		System.out.println("전원을 끄기");
	}
	
	void 통화하기() {
		System.out.println("통화하기");
	}
	//toString() 오버라이딩
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
	
	
	
	
}
