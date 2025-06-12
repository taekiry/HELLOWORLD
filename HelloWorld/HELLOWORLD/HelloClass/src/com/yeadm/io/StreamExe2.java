package com.yeadm.io;

import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * 문자 기반 입력,출력 스트림.
 */

public class StreamExe2 {
	public static void main(String[] args) {
		Scanner scn = null;
		// 파일 기반의 입출력스트림.
		try {
			scn = new Scanner(new File("c:/temp/writer.txt"));
			while (true) {
				String data = scn.nextLine();
				//data : 홍길동 70
				String[] strAry = data.split(" "); 			//문자열 data를 공백을 기준으로 나눔. => 배열 생성.
				System.out.println(strAry[0] + ", " + strAry[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scn.close();
		}
		System.out.println("end of prog");
	}

	public static void read() {
		// char 기반의 입력스트림.

		try {
			Reader rd = new FileReader("c:/temp/writer.txt");

			while (true) {
				int data = rd.read(); // char을 int에 저장. A,B,B - > 65 66 67
				if (data == -1) {
					break;
				}
//						System.out.print(data);
				System.out.print((char) data); // casting
			}
			rd.close();
			System.out.println();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// end read()

	public static void write() {
		// char 기반의 출력스트림.
		try {
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}// end write()

}// end StreamExe2
