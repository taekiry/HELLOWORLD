package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		int num1 = 10;
		String str = "*";;
		cal.printStar(num1,str);   	//매개변수 times에 매개값 10을 넣음(num1도 매개변수로 읽으면안됨.)
		String result = cal.printStar(num1,str);// void라서 리턴값이 없음 -> 불가능
		System.out.println(result);
		
		double sum = cal.add(num1, 10.5); 			//num1이 10인데 메소드에따라 10.0으로 변환후 10.5더함
		System.out.println(sum);
		
		//println의 메소드가 string, int, boolean 값 받을 수 있게 정해져있음 오버로딩 예시
//		System.out.println("10");
//		System.out.println(10);
//		System.out.println(true);
		
		int[] numAry = {10,20,30};
		sum = cal.add(numAry);
		System.out.println(sum);
		
		//Member[] 중에서 point가 큰 회원을 반환
		Member[] members = {new Member("user01","홍길동","1111",1000)
						   ,new Member("user02","김민규","2222",2200)
				           ,new Member("user03","황선홍","3333",2700)
				           ,new Member("user04","홍명보","4444",1900)
		};
		
		//반환유형 = Member, 매개변수(Member[])
		Member member = cal.getMaxPoint(members);
		
		member.showInfo(member);
		
		
	}//end main
}//end class
