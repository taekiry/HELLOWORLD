package com.yeadm.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림.
 * 기본타입 - 참조타입
 * int num = 10; 실제값 10이 담겨있음.
 * Member member = new Member(); member는 Member객체 위치의 주소값을 참조.
 * 직렬화(Serialization) : 객체를 기본타입으로 변환.(모든객체x)
 * Serializable 인터페이스로 구현하는 클래스들만 가능.
 * 
 * 역직렬화(Deserialization) : 기본타입을 객체로 변환.
 */
class Product implements Serializable { //ArrayList는 직렬화 가능하지만 Product는 불가기때문에 implements 해야함.
	String productCode;
	
	public Product(String productCode) {
		this.productCode = productCode;
	}
}



public class StreamExe4 {
	public static void main(String[] args) {
		
		try { //기본타입 -> 객체 타입 : 역직렬화.
			InputStream is = new FileInputStream("c:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			List<Product> list = (List<Product>)ois.readObject(); //ClassNotFoundException 발생가능.
								 //Product타입의 list로 캐스팅 (object타입은 모든클래스의 상위 클래스기때문에 어떤형태로든 casting가능)
			for(Product product : list) {
				System.out.println("상품코드: "+ product.productCode);
				// 아까 공백으로 구분해서 저장하던 방법이 필요가 없어짐. 객체보조스트림이 있어서
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void serial() {	//객체를 출력시스템에 전달하기위해.직렬화
		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));
		list.add(new Product("P002"));
		
		try {
			//기본 출력스트림
			OutputStream os = new FileOutputStream("c:/temp/object.db");
			//(객체 입출력) 보조 출력스트림.
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(list); // writeObject 객체를 기본타입으로 변환 출력스트림에 전달하는 보조스트림.
			oos.close();
			os.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}//end StreamExe4
