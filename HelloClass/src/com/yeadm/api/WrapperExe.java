package com.yeadm.api;

public class WrapperExe {
	public static void main(String[] args) {
		
		int num = 10;							//기본데이터 타입
		//num. 기본데이터 타입이라 .붙여도 아무것도 안나옴.
		
		//Integer num2 = new Integer(20);		//참조데이터 타입. Class라서
		Integer num2 = 20;						//박싱
		
		num = num2.intValue(); 
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str);		//Float type(4byte) < Double(8byte) 자동형변환.
		
		/*
		 *박싱, 언박싱
		 * 기본데이터타입 10을 Wrapper(참조)타입 Integer로 (박싱)
		 * 참조 -> 기본 (언박싱)
		 */
		Integer num4 = new Integer(10); //기본데이터타입 10을 Wrapper(참조)타입 Integer로 (박싱)
		Integer num5 = new Integer(10); //참조 -> 기본 (언박싱)
		System.out.println(num4 == num5);  //false
		System.out.println(num4.intValue() == num5.intValue()); //true
		//intValue 데이터의 정수 값으로 변환.
	}
	
}//end WrapperExe
