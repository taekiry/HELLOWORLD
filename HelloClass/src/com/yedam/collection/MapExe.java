package com.yedam.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Map 컬렉션
 * {Key : Value} 추가.
 * list의 index 대신 Key.
 */
class Student2 {
	// 학생 (이름, 점수)
	private String studentName;
	private int score;

	// 생성자
	public Student2(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}

	// getter
	public String getStudentName() {
		return studentName;
	}

	public int getScore() {
		return score;
	}

	// HashMap을 써서 overriding
	@Override
	public int hashCode() { 
		return score;
		//return studentName.hashcode(); --> hashcode가 반환하는 값이 같다면 equals로
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student2) {
			Student2 std = (Student2) obj;// Object에 stuName, score가 없기때문에 casting해야함.
			return this.studentName.equals(std.getStudentName()) && this.score == std.getScore(); // hashcode에서 비교했지만 확실하게하려고 한번더.
		}
		return false;
	}

}// end student2

public class MapExe {

	public static void main(String[] args) {

		// 학생(Key), 반(Value)
		Map<Student2, String> map = new HashMap<>();

		map.put(new Student2("홍길동", 70), "1반");
		map.put(new Student2("김민규", 80), "2반");
		map.put(new Student2("박철승", 75), "1반");
		map.put(new Student2("최성철", 85), "2반");

		// 반복문.
		// 이름,키 두개로 조회(?)
		String keyword = "홍길동";
		int score = 70;
		//객체를 == 비교연산자로 비교할경우 항상 false.// 주소값 힙영역이 다름 -> false
		System.out.println(new Student2(keyword, score) == new Student2(keyword, score)); 
		System.out.println(map.containsKey(new Student2(keyword, score))); //-해결- 왜 false일까(오버라이딩실수)
		
		if (map.containsKey(new Student2(keyword, score))) { // new ->다른객체 생성했지만 hashcode, equals로 이름,점수같으면 동등객체 취급.
			System.out.println("반: " + map.get(new Student2(keyword, score)));
		}

		// 이름으로 key 조회 -> value값까지
//	;	Set<Student2> set = map.keySet();
//		
//		Iterator<Student2> iter = set.iterator();
//
//		while (iter.hasNext()) {
//			Student2 std = iter.next(); // 순서 상관없이 한건 가져옴.
//			if (std.getStudentName().equals(keyword)) {
//				//System.out.println("점수: " + std.getScore());
//				// 이름, 점수
//				String cls = map.get(std); // map.get(std) -> 객체 키로 반 정보 반환
//				System.out.printf("이름: %s\n점수: %d\n반: %s\n",std.getStudentName(),std.getScore(),cls);
//			}
//		} // end while

	}// end main

	public static void exe1() {

		Map<String, Integer> map = new HashMap<>();

		// 추가.
		map.put("홍길동", 80);
		map.put("김민수", 70);
		map.put("홍길동", 95); // 동일한 키 값에 다른 value -> 나중에 넣은 value가 저장.덮어씀
		map.put("박철민", 65);

		// 조회. (키 입력 -> 값 반환)
		Integer score = map.get("홍길동");
		System.out.println(score);

		// 삭제.
		// map.remove("홍길동");

		// 반복. key값 찾기.
		Set<String> keyset = map.keySet(); // key를 Set컬렉션으로 반환.

		// 반복자.
		Iterator<String> iter = keyset.iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			Integer value = map.get(key); // map.get(key) -> 키에 해당하는 value값 반환.
			System.out.printf("키: %s, 값: %d\n", key, value);
		}

		// { key : value} 반환. -> Map.Entry 타입
		Set<Entry<String, Integer>> entryset = map.entrySet();

		Iterator<Entry<String, Integer>> iter1 = entryset.iterator();

		while (iter1.hasNext()) {
			Entry<String, Integer> entry = iter1.next();
			System.out.printf("키: %s, 값: %d\n", entry.getKey(), entry.getValue());
			// entry타입의 변수 entry에 객체정보 저장후 getKey, getValue로 가져옴.
		}

		// maven repository 외부라이브러리 -> dev에 다운 -> helloclass build path -> external Jar

		// java 객체 map을 JSON format 문자열로 출력.

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); // toJson -> 문자열로 변환
		System.out.println(json);

		// key나 value에 또다른 클래스가 들어갈 수 도 있음.

	}// end exe1

	public static void exe2() {
		// key: string, Value : string 타입

		Map<String, String> map;
		map = new HashMap<String, String>();

		map.put("user01", "1111");
		map.put("user02", "2222");
		map.put("user03", "3333");

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("ID를 입력>> ");
			String id = scn.nextLine();
			System.out.println("PW를 입력>> ");
			String pw = scn.nextLine();

			if (map.containsKey(id)) { // containsKey -> boolean 값으로 키가 존재하는지 안하는지
				// Key값이 존재 -> 비밀번호(Value)체크
				if (map.get(id).equals(pw)) { // map.get(id)가 value값 반환하니까 pw랑 비교.
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("존재하지 않는 ID입니다.");
			}
		} // end while

		// java 객체 map을 JSON format 문자열로 출력.

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); // toJson -> 문자열로 변환
		System.out.println(json);
	}// end exe2

}// end MapExe
