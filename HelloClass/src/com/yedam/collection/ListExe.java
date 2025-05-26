package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.member.Member;


/*
 * < List 인터페이스 >
 * 인덱스를 활용해서 객체를 관리.
 * 순서를 가지고 중복된 값도 가능.
 */
class Student {
	private int studentNo; // 1001, 1002, 1003... 1010 10명;
	private int score;
	
	public Student(int studentNo,int score) {
		this.studentNo = studentNo;
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	
}

public class ListExe {
	public static void main(String[] args) {
		// 10 ~ 100점 점수를 임의의 값으로 생성.
		
		List<Student> students = new ArrayList<>(); //<>앞의 List<>타입에 연동. 안써도됨.
		//10개의 점수의 합, 평균 출력.
		
		int sum = 0;
		int score = (int)(Math.random() * 91) + 10;
		
		for(int i = 0; i < 10; i++) {
			//Student student = new Student(i + 1001, score);
			
			students.add(new Student(i + 1001, score));
			sum += students.get(i).getScore();
			
		}
		double avg = 1.0 * sum / 10;
		System.out.printf("합계는: %d\n평균은: %.1f",sum,avg);
		
		
		List<Integer> numbers = new ArrayList<>(); //<>앞의 List<>타입에 연동. 안써도됨.
		//10개의 점수의 합, 평균 출력.
		int sum1 = 0;
		int num1 = (int) (Math.random() * 91) + 10;
		
		for(int i = 0; i < 10; i++) {
			numbers.add(num1);
			sum1 += numbers.get(i);
		}
		double avg1 = 1.0 * sum1 / 10;
		System.out.printf("합계는: %d\n평균은: %.1f",sum1,avg1);
		
		
	}
	
	public static void exe2() {
		List<Member> members = new ArrayList<>();   
		//ArrayList<>앞에 멤버 안쓰더라도 알수 있음/.
		Member member = new Member("김홍동", 20);
		members.add(new Member("홍길동", 10));
		members.add(member);
		members.add(new Member("김홍도", 30));
		
		//목록 삭제.
		
		
		String search = "김홍동";
		for (int i = 0; i < members.size(); i++){
			if(members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}
		// 목록출력.
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString()); //members의 목록을 String값으로 출력.
		}
		
		
	}// end main
	
	public static void exe1() {
		// 인터페이스 - 구현클래스
		// ArrayList list = new ArrayList();
		List<String> list = new ArrayList<String>(); // String타입만 담겠습니다.
		// list.add(new Integer(10));
		list.add("10");
		list.add(new String("Hello")); // int[] ary = {10,20,30.5} 불가능
										// add안에 담을 수 있는것 -> Object 클래스의 상속을 받는것들.

		
		list.add(1,"20"); //인덱스값 1 => 두번재 위치에 20들어감
		
		// 삭제.
		list.remove(0);
		for(int i = 0; i < list.size(); i++) { //list는 컬렉션이니까 length X
			System.out.println(list.get(i));
		}

		//변경.
		list.set(1, "world");
		
		
		
		for (String item : list) {
			System.out.println(item);
		}
	}// end exe1

}// end ListExe
