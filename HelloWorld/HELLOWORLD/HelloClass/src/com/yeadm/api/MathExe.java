package com.yeadm.api;

public class MathExe {
	public static void main(String[] args) {
		// 절대값.
		System.out.println(Math.abs(-100));
		System.out.println();
		
		// 올림, 버림.
		System.out.println(Math.floor(12.3));
		System.out.println(Math.ceil(12.3));
		System.out.println(Math.round(12.3)); // 반환값이 정수.
		System.out.println();
		
		// 크기 비교.
		System.out.println(Math.max(22, 44));
		System.out.println(Math.max(Math.ceil(12.3), Math.floor(12.3)));
		 
	}

}//end MathExe
