package com.yeadm.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {// project Explorer 에서 F2누르면 리네임가능 다른곳에 쓰고있다면전부다.
	
	public static void main(String[] args) {
		
		/*
		 * 배열[여러건 저장] 한번 지정하면 크기 변경 불가해서 불편 
		 * => 컬렉션 (1.List 2.Set 3.Map)
		 * Set : A collection that contains no duplicate elements.(중복값 X)
		 * 
		 */
		int[] ary = new int[5]; 					//  정수타입 배열
		//확장된 for
		for(int num : ary) { //배열의 개수 만큼만 반복.
			System.out.println(num);
		}
		
		Set<Integer> set = new HashSet<Integer>();	// 정수타입 컬렉션 
		
		//Set이 인터페이스 -> 인스턴스 생성불가 but HashSet이라는 자식클래스로 인스턴스 구현.
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(10);  //set 컬렉션은 저장 순서 X, 중복된값 저장하지 않기 때문에 10하나 출력 X
		
		for(Integer num : set) {
			System.out.println(num);
		}
		
		// Member처럼 직접 선언하는 클래스는 어떤가?
		
		Set<Member> members = new HashSet<Member>(); //Member 타입 컬렉션
		members.add(new Member("홍길동",10));
		members.add(new Member("김민석",12));
		members.add(new Member("홍길동",10));  
		//중복된값이라 저장하지 않을까? No. 
		//com.yeadm.api.Member@1f32e575
		//com.yeadm.api.Member@279f2327
		//com.yeadm.api.Member@5305068a
		//toString이 Object 클래스 그대로 써서 위처럼 출력됨. Overriding 필요.
		
		for(Member num : members) {
			System.out.println(num.toString());
		}
		//hashCode 메소드로 age를 반환해서 그룹화 -> 내장 equals로 비교 ->
		//set Member 컬렉션에 동일한 값은 중복되어 추가가 안됨.
		
		
	}//end main
	
	
	
	
	
	public static void exe1() {
		int num1 = 10, num2 = 20;
		System.out.println(num1 == num2);

		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2));

		Member mem1 = new Member(); //인스턴스의 주소1
		Member mem2 = new Member(); //주소2 주소를 비교
		
		mem1.memberName = "홍길동";
		mem1.age = 10;
		mem2.memberName = "홍길동";
		mem2.age = 10;
		
		System.out.println(mem1.equals(mem2));   // Member클래스가 Object클래스를 상속받았기때문에
												 // equals 사용가능
												 // equals를 오버라이딩 했기때문에 true값이 나옴.
		
	}

}
