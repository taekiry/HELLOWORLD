package com.yedam.ref.exe;

public class TodoExe {
	public static void main(String[] args) {
		
		// 임의의 숫자 생성.
		/*각 배열의 numAry[0], numAry[1], numAry[2]의 평균을 출력하세요. 아래의 모양처럼 출력이 되도록 하세요.

		numAry[0]의 평균은 34.56
		numAry[1]의 평균은 49.62
		numAry[2]의 평균은 69.30 */
		
		int[][] numAry = new int[3][5];
		int sum = 0;
		for (int outer = 0; outer < numAry.length; outer++) {
			for (int inner = 0; inner < numAry[outer].length; inner++) {
				numAry[outer][inner] = (int) (Math.random() * 100);

				for(int o = 0; o < numAry.length; o++) {
					if( outer == o) {
						sum += numAry[outer][inner];
					}
				}
			}
			double avg = 1.0 * sum / numAry.length;
			System.out.printf("numAry[%d]의 평균은 %.2f\n",outer,avg);
		}

	}//end main
}//end class