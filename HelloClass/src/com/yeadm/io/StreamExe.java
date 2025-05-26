package com.yeadm.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		
		// original2.PNG (1.1M) -> copy3.PNG
		try {
			long start = System.currentTimeMillis();
			InputStream is = new FileInputStream("c:/temp/original2.PNG");
			OutputStream os = new FileOutputStream("c:/temp/copy3.PNG");
			
			//보조스트림 생성자의 매개값으로 기본스트림을 연결.
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			//읽기 - 쓰기
			while(true) {
				int data = bis.read();
				if(data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.close(); bis.close();
			os.close(); is.close();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}// end of main

	//파일 복사 method
	public static void copy() {
		// 입력 스트림 -> 출력 스트림. (copy)

		try {
			// 입력스트림(original.png)
			InputStream is = new FileInputStream("c:/temp/original2.PNG");

			// 출력스트림(copy.png)
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");
			// 1byte - > 속도저하. byte배열 지정-> 속도향상.
			// 한번에 읽기쓰기 byte[] 만큼 한번에 처리.
			byte[] buf = new byte[10];
			long start = System.currentTimeMillis();
			while (true) {
				int data = is.read(buf); // 1byte를 읽기 (buf)-> byte배열 크기만큼 읽기
				if (data == -1) { // 읽어올 데이터 더이상없으면 -1 출력
					break;
				}
				os.write(buf); // 1byte를 쓰기.
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis();
			System.out.println("걸린시간: " + (end - start));
		} catch (IOException e) { // fileNotFound보다 상위 IOException
			e.printStackTrace();
		}
		System.out.println("end prog");

	}

	public static void read() {

		// 입력(파일) 바이트 기반.
		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read() 1바이트씩 읽기 / -1 : 파일의 끝. 더이상 읽을값이 없음을 표현

			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("end prog");

	}// end read

	public static void write() {
		// 출력 스트림(파일) 바이트 기반.
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);

			os.close(); // 입출력스트림 사용하고 close.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end write

}// end StreamExe
