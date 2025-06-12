package com.yedam.ref;


/*
 * 배열 + 기본타입 : 정수, 실수 
 * 배열 + 참조타입(class) : 학생의 이름, 점수 -> 복합적 형태 배열
 */

public class ArrayExe3 {
	
	static Student[] stdAry;					//class범위에 선언해서 (main,test)어디에서든 쓸 수 있음.
	
	public static void main(String[] args) {
		
		//test(); 제일먼저 복습
		init();   				// 샘플데이터 생성
		
		//배열의 값을 출력. -> 샘플데이터 출력
		int sum = 0;
		double max = 0;
//		String maxName = "";
		Student maxStd;
		maxStd = new Student();
//		maxStd.studentName ="";//쓸필요 없음 Student에 이미 studentName이 존재하고 따로 지정안하면 null이 있어서
		
		
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름: %s 점수: %d \n",stdAry[i].studentName,stdAry[i].score);
			sum += stdAry[i].score;
//			if ( max < stdAry[i].score) { //최고점수
//				max = stdAry[i].score;
//				maxStd.score = max;
//				maxStd.studentName = stdAry[i].studentName;
//			}
			if ( max < stdAry[i].height) { // 가장 큰키, 키큰학생
				max = stdAry[i].height;
				
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}
		double avg = 1.0 * sum / stdAry.length;
	//	System.out.printf("합계: %d, 평균: %.2f\n최고점수: %d 이름: %s",sum,avg,max,maxStd.studentName);
		
	 	String strFmt = "키큰학생: %s, 점수: %d, 키: %.1f 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height ,avg);
		
	}//end main
	
	
	public static void init() {    //샘플데이터 생성
		Student s1 = new Student();  		
		s1.studentName = "홍길동";				
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;  //열거형타입 Gender의 Male로
	
		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = Gender.FEMALE;
		
		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 180.3;
		s3.gender = Gender.MALE;
		
		stdAry = new Student[] {s1, s2, s3};   	//변수를 위에 선언했고,student 데이터타입의 배열을 할당 
				
	}//end init
	
	
	public static void test() {
			
		//홍길동, 80점
			
		Student s1 = new Student();     		// 데이터 타입이 student인 s1 인스턴스 생성.
		s1.studentName = "홍길동";				// 
		s1.score = 80;
		
		//김민규, 85점
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;
			//홍길동의 점수를 90으로 변경
		s1.score = 90;
		
		//학생정보를 배열에 저장.
		Student[] students = { s1, s2 };   //데이터타입이 Student인 students라는 배열에 홍길동,90점 / 김민규,85점 이 들어감 
		students[0].studentName = "홍길도";  // student[0]은 s1이기때문에
		System.out.printf("이름: %s, 점수: %d\n",s1.studentName, s1.score);
				
	}//end test

	
}// end class
