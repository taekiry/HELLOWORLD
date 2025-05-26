package com.yeadm.api;

import java.util.Scanner;

public class Review5 {

	public static void main(String[] args) {
			
//		long time = System.currentTimeMillis();
//		System.out.println(time);
//		long time1 = System.nanoTime();
//		
//		int sum = 0;
//		for(int i = 0; i <= 1000000; i ++) {
//			sum += sum + i;
//		}
//		long time2 = System.nanoTime();
//		long runTime = time2 - time1;
//		System.out.println(runTime);
//		
		// 1)성별을 반환(남성/ 여성)
				String[] samples = { "9503061234567"//
						, "990603 2345678"//
						, "030502-3456789" };
				for (int i = 0; i < samples.length; i++) {
					String gender = StringUtil.getGender(samples[i]);
					System.out.printf("%s는 %s입니다.\n", samples[i], gender);
				}

				// 2)파일명의 확장자정보를 반환(파일확장자)
				String[] files = { "c:/temp/orange.jpg"//
						, "d:/storage/test/grape.jpeg"//
						, "d:/img/melon.png" };
				// 배열에 저장된 파일명에 해당하는 확장자(jpg, jpeg, png) 구하기.
				for (int i = 0; i < files.length; i++) {
					System.out.printf("파일의 확장자는 %s입니다.\n", StringUtil.getExtName(files[i]));
				}
				//교수님 깃허브 참고.
			
				
				//윤년
				
				System.out.println("년도를 입력>>");
				Scanner scn = new Scanner(System.in);
				int year = Integer.parseInt(scn.nextLine());
				
	}
		
			 static boolean isLeafYear(int year) {
				boolean leafYear = true;
				if ( year % 4 == 0) {
					if ( year % 100 != 0 && year % 400 == 0) {
						leafYear = true;
					} else {
						leafYear = false;
					}leafYear = false;
				}
			return leafYear;
	}
}//end review5
