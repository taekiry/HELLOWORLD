package com.yedam;

/*
 * 실행 클래스.
 */

public class StudentExample {

	public static void main(String[] args) {
		
	  // 클래스     변수       인스턴스 생성.
		Student student = new Student();
//		student.studentNo = 1001;
		student.setStudentNo(1001);
//		student.studentName = "홍길동";
		student.setStudentName("홍길동");
//		student.engScore = 80;
//		student.mathScore = 85;		//속성값에 직접 대입
		student.setMathScore(85);   //메소드의 매개값
		student.setEngScore(80);
		student.study();
		student.introduce();
		System.out.println("이름: " + student.getStudentName() + " 영어: " + student.getEngScore() + " 수학: " + student.getMathScore());
		
		Student student2 = new Student(1002,"김민규");  //필드에 값 입력 x 생성자에 바로
//		student2.studentNo = 1002;
		
//		student2.studentName = "김민규";
		
//		student2.engScore = -50;    // -50 형식은 맞는값(int)
//		student2.mathScore = -80;
		student2.setMathScore(-80);   //메소드의 매개값
		student2.setEngScore(-50);
		student2.study();
		student2.introduce();
				
//		student2.studentName = "박민규";  //김민규에서 박민규로 변경
		student2.setStudentName("박민규");
		student2.setStudentNo(1123);
		student2.introduce();
		
		
	}//end main
	
}//end class
