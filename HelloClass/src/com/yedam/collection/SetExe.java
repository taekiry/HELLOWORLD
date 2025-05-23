package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		// Set컬렉션.
		Set<String> set = new HashSet<>();		//
		set.add("홍길동");
		set.add("월요일");
		set.add("금요일");
		
		if(set.contains("홍길동")) {
			
			System.out.println(set.remove("홍길동")); //지워져서 true 지울것없으면 false. 
													// add랑 remove는 boolean 타입 반환.
		}
		
		// 반복.
		Iterator<String> iter = set.iterator();//반복자 획득. 반복요소 순번매겨서 출력해주기위해서.
		//set.iterator(); 쓰려면 Iterator도 java.util에서 임포트해줘야함.
		
		while(iter.hasNext()) { //hasNext : iterator가 가져올게 있는지 없는지 boolean으로 반환.
			String result = iter.next();	// 
			System.out.println(result);
		}
		
	}
}
