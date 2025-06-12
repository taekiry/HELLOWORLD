package com.yedam;

/*
 * 라이브러리 클래스.(참조역할) 
 */
							
public class Student { //static이 없는 class -> 반드시 인스턴스 선언해야 작동 따라서 정적인 클래스
	
	 //필드(속성) 객체의 데이터 저장 
	private int studentNo; 		 		//학생 번호 (private -> student클래스 안에서만 바꿀수있음 외부접근불가)
	private String studentName;      	//학생 이름
	private double height;
	private int engScore;
	private int mathScore;
	
	 //생성자(객체 : instance) : 객체생성 시 필드의 값 초기화
	public Student() {
		// ()안에 매개값이 없는 생성자 : 기본생성자
		// 따로 정의하지않으면 컴파일러가 자동 생성
		// 생성자 여러개 생성가능.
	}
	
	public Student(int studentNo, String studentName) {
		this.studentNo = studentNo;  	//첫번째 매개값은 학생번호
		this.studentName = studentName;	//두번째 매개값은 학생이름
	}
	// --> 직접쓴 생성자 방식으로 사용하겠다라는 의미 -> 기본생성자 사용 x
	
	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
//질문 생성자 생성시 int 1 int2 짜리 하나만들고
//다른 생성자에 영어점수1(int) 수학점수1(Int) 하나 만든다면 에러코드 발생 
//타입과 매개변수 개수가 같은 생성자는 두개를 만들 수 없다.

	 //메소드(기능) //
	void study() {
		System.out.println("공부를 합니다.");
	}
	
	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s\n", studentNo, studentName);
	}
	
	//영어, 수학 점수
	void setEngScore(int engScore) {
		if(engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}
	
	void setMathScore(int mathScore) {
		if(mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}
	
	int getEngScore() {    // exe클래스에서 private때문에 직접사용이 불가능해서 메소드 만드는것?
		return engScore;
	}
	
	int getMathScore() {   
		return mathScore;
	}
	
	//학번, 학생명 메소드
	void setStudentNo(int studentNo) { //필드에 지정하겠다로 끝 반환값없음.
		this.studentNo = studentNo;
	}
	
	void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	//학생넘버를 반환 (public도 private도 아닌 상태 public에 더가까움)
	int getStudentNo() {
		return studentNo;
	}
 	
	//학생 이름을 반환
	String getStudentName() {
		return studentName;
	}
	
}// end class

