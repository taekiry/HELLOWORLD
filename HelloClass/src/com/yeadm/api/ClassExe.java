package com.yeadm.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.yeadm.api.Member"); // 클래스 Class.forname => Member의 값들을 전부가져옴
			Member member = new Member();
			cls = member.getClass();  //member인스턴스 만들어서 getclass 위에 Class.forName과 같은역할
			System.out.println(cls.getName());
			cls.getDeclaredFields(); // field들을 배열로 반환해주는 메소드
			//선언된 필드 확인하기.
			Field[] fieldAry = cls.getDeclaredFields();
			
			for(Field field : fieldAry) {  //필드어레이의 갯수만큼 변수 필드 반복
				System.out.println(field.getName());  // 클래스의 메타정보 필드들을 보여줌.
			}
			
			// 메소드 확인하기;
			Method[] methodAry = cls.getDeclaredMethods(); //클래스에 선언된 메소드들 확인.
			for(Method method : methodAry) {
				System.out.println(method.getName());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
