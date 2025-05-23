package com.yeadm.api;

import java.awt.SystemColor;

public class SystemExe {
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		//System.out.println(now);
		//1747964906 => 초단위 => 몇일, 몇시간, 몇분, 몇초를 반환.
		timeCalculator();
		
		
		
	}//end main
		
		public static void timeCalculator() { //교수님꺼보기
			
			long time = 1747964906;
			long year = time / (60 * 60 * 24 * 365);
			System.out.println(year);
			
			long day = (year * 365) %(60 * 60 * 24);
			
			System.out.println(day);
			long hour = ((day * 24) % 24) / (60 * 60);
			System.out.println(hour);
			
			long min = (hour % 60 )/ 60;
			//System.out.println(min);
			long sec = min % 60;
			
			
			
			//System.out.printf("며칠: %d\n몇시간: %d\n몇분: %d\n몇초: %d\n",day,hour);
			
		}
	
	
		
		public static void exe() {
		//currentTimeMillis
		long start = System.currentTimeMillis(); //현재 시스템 시간을 long타입으로 출력. 1970 0101부터 
		int sum = 0;
		for(int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.currentTimeMillis();
		System.out.printf("합계: %d\n걸린시간: %d\n",sum,(end - start));
		
		long start1 = System.nanoTime(); // nanoTime. 10억분의 1초단위
		int sum1 = 0;
		for(int i = 0; i < 100000000; i++) {
			sum1 += i;
		}
		long end1 = System.nanoTime();
		System.out.printf("합계: %d\n걸린시간: %d\n",sum,(end1 - start1));
		
	}//end exe

}//end class

