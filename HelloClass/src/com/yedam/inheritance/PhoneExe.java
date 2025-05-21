package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		//부모클래스.
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOff();
		phone1.powerOn();
		phone1.통화하기();
		System.out.println(phone1.toString());
		
		//SmartPhone phone2 = new SmartPhone(); //SmartPhone 클래스에 필드,메소드 안 적어줬지만 상속으로 가능.
		
		CellPhone phone2 = new SmartPhone(); 
		phone2.model = "S21";
		phone2.color = "white";
		phone2.powerOff();  //부모클래스의 기능을 사용하지만 자식 클래스 인스턴스가 할당되어서 다른모양 출력
		phone2.powerOn();
		phone2.통화하기();
	
		//부모타입 변수에 자식클래스 인스턴스가 담겨질수 있다.
		//but 부모클래스의 기능만 실행가능
		
		SmartPhone phone3 = null;
		if(phone2 instanceof SmartPhone) {//true
			phone3 =(SmartPhone) phone2;//phone2는 부모클래스 타입 -> 자식클래스 타입으로 형변환 해줘야 담을 수 있음 
			phone3.channel = 2; 
			phone3.watch();
			phone3.toString();
			System.out.println(phone3.toString());
		}
		
		//instanceOf 메소드의 변환이 가능한지 체크
		if(phone1 instanceof SmartPhone) {  //false
		phone3 = (SmartPhone) phone1;		//phone1 참조변수의 인스턴스 유형이 스마트폰이 맞으면 밑에 캐스팅
		phone3.channel = 3; 
		phone3.watch();
		}
		//문법상 오류 x but 캐스팅오류 
		//.CellPhone cannot be cast to class com.yedam.inheritance.SmartPhone
		
	}

}
