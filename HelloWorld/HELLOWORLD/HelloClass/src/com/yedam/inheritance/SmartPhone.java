package com.yedam.inheritance;

/*
 * CellPhone Class를 상속.
 */
public class SmartPhone extends CellPhone{

		int channel;
		public SmartPhone() {
			super(); //부모클래스의 기본생성자가 X라서 
		}
		
		
		void watch() {
			System.out.println(channel + "을 시청합니다.");
			
		}
	
		public SmartPhone(String model, String color, int channel) {  //부모에 전체생성자 존재 -> 자식에 전체생성자 만들어야 오류X
			super(model, color);
			this.channel = channel;
		}


		//부모클래스의 기능을 자식클래스에서 재정의(Overriding)
		public void powerOn() {
			System.out.println("전원을 켭니다🚗🔥🚗🔥");	
		}
		@Override  //crtl + space  // @하면 부모클래스의 메소드이름이 맞는지, 매개값이맞는지, 타입 맞는지 확인해줌.
		
		public void powerOff() {
			System.out.println("전원을 끕니다🚗🔥🚗🔥");	
		}
		
		@Override//"toString" 메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드 입니다.
		public String toString() {
		// TODO Auto-generated method stub
		// Overrides: toString() in CellPhone	
		return super.toString();
		}
		
		
		
		
}// end SmartPhone
