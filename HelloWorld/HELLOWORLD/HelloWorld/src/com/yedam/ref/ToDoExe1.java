package com.yedam.ref;

import java.util.Scanner;

public class ToDoExe1 { 	// ToDoExe 에서 Student 클래스 활용해서 수정한 파일
	
	public static void init() {    //샘플데이터 생성
		Student s1 = new Student();  		
		s1.studentName = "홍길동";				
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;;
	
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
		
		scores = new Student[] {s1, s2, s3};
		
	}//end init
	
	static Student[] scores = null;

	public static void main(String[] args) {
		init();  // init 활성화 -> 초기데이터 생성
		boolean run = true;
		int studentNum = 0;
		boolean isEmpty = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트(성별) | 4.분석 | 5.종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			
			//배열의 선언없이 메뉴를 선택할 경우에 NullPointer예외발생
			 if(selectNo == 2 || selectNo ==3 || selectNo ==4) {
			 	 if(scores == null) {
			 		System.out.println("학생수를 지정하세요.");
			  		continue; 
			  }
			 }// ---> 이방법쓰면 1번 안눌렀을시 발생 
			
			if (selectNo == 1) {	
				
				System.out.print("학생수 >> ");
				studentNum = Integer.parseInt(scn.nextLine());	
				scores = new Student[studentNum];  		      // 학생수를 지정하면 배열의 크기가 생기게
			
			} 
			
			else if (selectNo == 2) {
				
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d] 이름>> ", i); //print와 같이 옆에 적을수있음, format지정은가능
					String name = scn.nextLine();
					
					System.out.printf("scores[%d] 점수>> ", i);
					int score = Integer.parseInt(scn.nextLine());
					
					System.out.printf("scores[%d] 키>> ", i);
					double height = Double.parseDouble(scn.nextLine()); //실수타입으로 입력시
					
					System.out.printf("scores[%d] 성별>> ", i);
					String gender = scn.nextLine();  //성별 저장.
					Gender gen = Gender.MALE; // 초기값 설정 안하면 error 발생해서
					if(gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}
					
					
					// 인스턴스 생성 --> student 데이터타입의 배열에 할당하기 위해서
					Student student = new Student();
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;
					scores[i] = student;  //배열에 할당
					
					isEmpty = false;
//					System.out.println();  => 줄바꿈 용도
				}
			}
			
			else if (selectNo == 3) {
				
				if (isEmpty) {
					System.out.println("먼저 점수를 입력해주세요.");
					continue;
				} else {
					System.out.print("성별을 입력하세요 남 또는 여>>");
					Gender gen = Gender.MALE; // gen 초기값 설정
					String keyword = scn.nextLine();
					if(keyword.equals("남") || keyword.equals("남자") ) {
						gen = Gender.MALE;
					} else if (keyword.equals("여") || keyword.equals("여자")) {
						 gen = Gender.FEMALE;
					}
					
					for (int i = 0; i < studentNum; i++) {
						if(keyword.equals("") || gen == scores[i].gender) { //엔터 치면 공백 -> 전체출력, 남=남 여=여) //데이터타입 string아니라서 비교연산자
							String strFmt = "scores[%d]이름>> %s\n성별>> %s\n키>> %.1f\n점수>> %d\n";
							System.out.printf(strFmt, i, scores[i].studentName,scores[i].gender,scores[i].height,scores[i].score);
						}
					}
				}
			}
			
			else if (selectNo == 4) {
				
				double max = 0;
				Student maxStd = new Student();
				int sum = 0;
				if (isEmpty) {
					System.out.println("먼저 점수를 입력해주세요.");
					continue;
				} else {
					for (int i = 0; i < studentNum; i++) {
						sum += scores[i].score;
						if (max < scores[i].height) {
							max = scores[i].height;
							maxStd.score = scores[i].score;
							maxStd.studentName = scores[i].studentName;
							maxStd.height = scores[i].height;
							maxStd.gender = scores[i].gender;
						}	
					}
				}
				
				double avg = 1.0 * sum / studentNum;
				String stdFormat = "가장 큰 학생이름: %s\n성별: %s키 : %.2f\n전체평균 점수 : %.2f\n";
				System.out.printf(stdFormat,maxStd.studentName,maxStd.gender ,maxStd.height, avg);
				
			} 
			
			else if (selectNo == 5) {
				run = false;
				
			}
		} // end while
		scn.close();
		System.out.println("프로그램 종료");
		
	}// end main
}// end class

