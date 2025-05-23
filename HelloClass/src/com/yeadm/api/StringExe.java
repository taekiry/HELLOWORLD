package com.yeadm.api;

public class StringExe {
	public static void main(String[] args) {
		String str1 = new String("Hello");
		//String str1 = "Hello"; 원래 위 생성자로 만들어야하지만 String이라 가능.
		str1 = new String(new byte[] {72, 101, 108, 108, 111});
		System.out.println(str1);
		// H e l l o -> 아스키코드 바이트값으로 배열된것과 같음.
//		str1 = new String(new byte[] {72, 101, 108, 108, 111},0,2); //0번부터 2개까지 출력.
		
		System.out.println(str1.charAt(1));  	// charAt 인덱스 1번값을 출력
		System.out.println(str1.indexOf("o"));  // " o "가 몇번째에 위치하는가.
		System.out.println(str1.indexOf("s"));  // 없는 값이라 -1 출력
		
		
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		System.out.println(sex);  // index 0번 부터
		
		String str ="안녕하세요";
//		byte[] bytes1 = str.getBytes();
		System.out.println(str.substring(5,-2));
	
		
		
	}//end main
	
}//end StringExe
