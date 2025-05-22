package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10; //상수 js에선 const
//		num = 30;
		
//		CellPhone phone = new SmartPhone();
		RemoteControl rc = new Television();
		
		rc.turnOn();
		rc.turnOff();
		
		rc = new Radio();
		rc.turnOn();
		rc.turnOff();
	}
}
