package com.yeadm.api;



public class StringUtil {
	static String getGender(String ssn) {//
		int pos = -1;// 성별 문자의 위치.
		pos = ssn.length() - 7; // 14-7=7
		System.out.println(pos);
		// 남성/여성 판별.
		char gNo = ssn.charAt(pos);
		switch (gNo) {
		case '1':
		case '3':
			return "남성";
		case '2':
		case '4':
			return "여성";
		default:
			return "알수없음";
		}
	}
//	public static String getGender(String gender) {
//		String backNum = gender.substring(gender.length()-7);
//		String backNum1 = backNum.substring(0,1);
//		
//		switch(backNum1) {
//		case "1":
//		case "3":
//			return "Male";
//		case "2":
//		case "4":
//			return "Female";
//		default:
//			return "알수없음";
//		}
//	}
	public static String getExtName(String file) {
		int pos = file.indexOf(".");
		return file.substring(pos+1);
	}
}//end StringUtil
