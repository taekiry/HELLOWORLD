package com.yeadm.api;



public class StringUtil {

	public static String getGender(String sample) {
		String str = sample.substring(sample.length()-7);
		String str1 = str.substring(0,1);
		if( str1.equals("1") || str1.equals("3")) {
			return "Male";
		} else if ( str1.equals("2") || str1.equals("4")) {
			return "Female";
		}return"모르겠습니다";
		
		
//		int char1 = sample.charAt(6); // 1 " " "-"
//		int char2 = sample.charAt(7); // 2 "2" "3"
//		int length = sample.length(); // 13, 14, 14
//		if (length == 13) {
//			if (char1 == 1 || char1 == 3) {
//				return "남";
//			} else {
//				return "여";
//			}
//		}
//		if (length == 14) {
//			if (char2 == 1 || char2 == 3) {
//				return "남";
//			}return "여";
//		}	
//		return "잘못 입력받았습니다"; // 전부 "여" -> chr1 값이 "1"이라서 아스키 코드 값이 49임.
	}

	public static String getExtName(String name) {
		int num = name.indexOf(".");
		String extName = name.substring(num+1);
		return extName;
	}

}//end StringUtil
