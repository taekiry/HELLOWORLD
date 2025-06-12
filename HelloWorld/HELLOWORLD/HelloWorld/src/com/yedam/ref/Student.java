package com.yedam.ref;

/*
 * 배열 + 기본타입 : 정수, 실수 
 * 배열 + 참조타입(class) : 학생의 이름, 점수 -> 복합적 형태 배열
 */

/*메인 메소드가 없음. 속성(필드)을 지정( 이름, 점수 ) 
 * 데이터 타입
 */
public class Student {
	String studentName;	  						// 이름 저장 용도 default : null
	int score;									// 점수 저장 용도 default : 0
	double height;
	Gender gender; // 열거상수 Male/Female 둘중하나 선택
	
}
