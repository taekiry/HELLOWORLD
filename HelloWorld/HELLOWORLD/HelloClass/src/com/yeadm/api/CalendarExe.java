package com.yeadm.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/*
 * Calendar : 날짜, 시간 클래스
 * Date : 날짜, 시간, 요일 
 */
public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025,5);
	
	}
	
	
	public static void makeCalendar(int year, int month) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("년도를 입력하세요>> ");
		year = Integer.parseInt(scn.nextLine());
		System.out.println("월을 입력하세요>> ");
		month = Integer.parseInt(scn.nextLine());
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH,month-1);  //-1때문에 Day_OF_WEEK도 헷갈렷다 이거부터확실히.
		
		int firstday = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		
		
		System.out.printf("         %d년 %2d월\n",year,month);
		System.out.println("=============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("=============================");
		
		
		for(int i = 1; i < firstday; i ++) {
			System.out.printf("%4s"," ");
		}
		
		for(int i = 1; i <= lastDay; i++) {
			System.out.printf("%4d",i);
			if((i + firstday - 1)  % 7 == 0) {
				System.out.println();
			}
			
		}
	}//end makeCalendar
	
	
		
		public static void date() {
			Date today = new Date();
			System.out.println(today.toGMTString()); 	//-----에러아님 기준시 + 9 = KR시간 22 May 2025 07:47:23 GMT
			System.out.println(today.toLocaleString()); //2025. 5. 22. 오후 4:47:23
			System.out.println(today.toString());	    //Thu May 22 16:47:44 KST 2025
			System.out.println();
			
			//2025-05-12 13:22:38 형태로 출력 2025년 MM월 dd일 형태도가능.
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //생성자의 매개값으로 포맷지정.
			
			String timestr = sdf.format(today); // Date를 원하는 String 타입으로 바꿈
			System.out.println(timestr);
			
			try {
				today = sdf.parse("2025-08-01 09:00:00"); //위에 선언한형식으로 지정 parse => String을 Date로
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			System.out.println(today);
		
		
		
	
			Calendar now = Calendar.getInstance(); //Calendar 클래스의 getInstance메소드 현재시간,날짜알려줌
			//시간 변경
			now.set(2025,0,1);
			now.set(Calendar.YEAR, 2024);
			
			//요일 출력.
			int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
			switch(dayOfWeek) {
			case 1: System.out.println("일요일");
					break;
			case 2: System.out.println("월요일");
					break;
			case 3: System.out.println("화요일");
					break;
			case 4: System.out.println("수요일");
					break;
			case 5: System.out.println("목요일");
					break;
			case 6: System.out.println("금요일");
					break;
			case 7: System.out.println("토요일");
					break;
			}
			
			
			
			// Calendar 클래스.
			
			System.out.printf("년도: %d\n 월: %d 날짜: %d 요일: %d 말일: %d",
					now.get(1),//now.get(Calendar.YEAR));
					now.get(Calendar.MONTH),			//month  1월달 값이 0
					now.get(Calendar.DATE),				//날짜 
					now.get(Calendar.DAY_OF_WEEK),		//요일 일요일: 1, 목요일 : 5
					now.getActualMaximum(Calendar.DATE) //달의 말일
						); 
	
			}
		}
