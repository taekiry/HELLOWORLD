package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		
		String str1 = "홍길동";                 //문자열 객체 "홍길동" -> str1 참조변수에 할당
		String str2 = null;                   //참조변수의 참조하는 값 없음
		
		//System.out.println(str2.toString());  //"toString" 메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
		                                      //null 값이라서  java.lang.NullPointerException 
	
//		let ary = [10,"string",11.2]  자바에선 불가능 같은 데이터 타입으로만 
		
		int[] ary = {10, 20, 30};             // int ary[] = {...} 같음
		System.out.printf("ary배열의 크기 %d", ary.length);
		
		int[] intAry;
		intAry = new int[] {40, 50, 60}; 	  //변수 선언후 배열을 할당하기
		
		
		//첫번째 위치의 값 40을 400으로 변경
		intAry[0] = 400;
		
		//인덱스 3 = 4번째 위치. 자바는 배열의크기가 선언시 고정됨.
//		intAry[3] = 10; 	// 구문에러는 안나지만 실행시 에러. Index 3 out of bounds for length 3
		
		//배열 크기 늘리려면 새로 선언해야함 (잘안씀)
		intAry = new int[5]; //배열의 크기 -> 5개 라는 뜻 인덱스값 아님
		intAry[0] = 40;
		intAry[1] = 50;
		intAry[2] = 60;
		intAry[3] = 10;
		
		System.out.printf("\n%d",intAry.length);
		
		//for 반복문으로 배열
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("\n[%d]번째의 값: %d", i, intAry[i]); 
		}
		
		for (int i = 0; i < intAry.length ; i++) {
			System.out.printf("\nintAry[%d]번째의 값: %d", i, intAry[i]); 
		}
		
		//배열 선언 : double 값을 담는 배열 dblAry 10.2, 23.2, 34.5
		
//		double[] dblAry = {10.2, 23.2, 34.5};
		
		/*double[] dblAry;
		dblAry = new double[3];
		dblAry[0] = 10.2;
		dblAry[1] = 23.2;
		dblAry[2] = 34.5;*/
		
		double[] dblAry = {10.2, 23.2, 34.5};
		
		for (int i = 0 ; i < dblAry.length; i++ ) {
			System.out.printf("\ndblAry의 [%d]번째 값 : %.1f", i ,dblAry[i]);
		}
		
		String[] strAry = new String[10];
		for (int i = 0 ; i < strAry.length; i++ ) {
			System.out.printf("\nstrlAry의 [%d]번째 값 : %s", i ,strAry[i]);
		}
		//string Array의 초기값은 Null이다. int의 초기값 0
		
		
	}//end main
	
}//end class
