package com.yeadm.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.collection.Student;

/*
 * 학생(추가,수정,삭제,목록)
 * -> 외부파일에 저장. studentList.txt (:c/temp)
 * add method(이름,점수 입력)
 * modify (이름으로 불러와서 점수수정)
 * remove (이름)
 * list(목록)
 * 종료시 저장.
 */

public class StreamExe3 {

	static Scanner scn = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {
		boolean run = true;

		try {
			init(); // init으로 studentList에서 불러옴.
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) { // IOExcption과 나눠서 처리하려고.
			// 파일의 끝부분에서 더이상 읽을 값이 없음.
		}
		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 1.추가
				add();
				break;
			case 2: // 2.수정
				modify();
				break;
			case 3: // 3.삭제
				break;
			case 4: // 4.목록
				break;
			case 5:
				run = false; // 종료시에 :c/temp/studentList.txt 만들고싶음.
				save();
			}
		} // end while
		System.out.println("end of prog");
	}// end main

	static void add() {
		Scanner scn = new Scanner(System.in);
		System.out.print("학생번호: ");
		String sno = scn.nextLine(); // studentno
		System.out.print("점수: ");
		String score = scn.nextLine();

		Student student = new Student(Integer.parseInt(sno), Integer.parseInt(score));
		if (studentList.add(student)) {
			System.out.println("저장 완료.");
		}

	}// end add

	// 저장. (문자 기반의 출력스트림)
	static void save() {
		try {
			Writer writer = new FileWriter("c:/temp/studentList.txt");

			// 1001 70 (학생번호 점수)
			for (Student student : studentList) {
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end save

	// 초기화. (문자 기반의 입력스트림)

	static void init() throws IOException, NoSuchElementException { // throws declaration 예외처리 방식. init을 호출한 곳에서 예외처리하라고
																	// 떠넘김.
		Scanner scn = new Scanner(new File("c:/temp/studentList.txt"));

		while (true) {
			String txt = scn.nextLine(); // 한 라인 읽어옴.
			String[] strAry = txt.split(" "); // 한 라인에 1001 70 공란을 기준으로 배열에 나눠넣음.
			// studentList 컬렉션에 추가. strAry[0]
			studentList.add(new Student(Integer.parseInt(strAry[0]), Integer.parseInt(strAry[1])));
		} //학생no, 점수 new student로 

	}// end init

	// 수정

	static void modify() {
		Scanner scn = new Scanner(System.in);
		System.out.print("학생번호: ");
		int sno = scn.nextInt(); // studentno
		System.out.print("점수: ");
		int score = scn.nextInt(); // nextInt int 타입으로 받음. 50 엔터 -> 50은 처리 but 엔터가 처리안돼
		scn.nextLine(); //엔터 친거까지 처리해줌. 
		// 컬렉션 값에서 검색.

		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentNo() == sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정완료");
				//return;
			}
		}

	}//end modify

}// end StreamExe3
