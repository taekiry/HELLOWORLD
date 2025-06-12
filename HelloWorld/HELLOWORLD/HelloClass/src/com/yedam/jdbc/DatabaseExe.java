package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement (for query)
 * 4. 실행
 * 5. ResultSet
 * 6. 출력.
 */

public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		// 세션.(오라클)(1)
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스가 있는지 check;
			conn = DriverManager.getConnection(url, id, pass); // 접속할 오라클 데이터베이스의 url 아이디 패스워드.
			conn.setAutoCommit(false);
			System.out.println("연결 성공.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// statement 객체.(2)
		Statement stmt = null;
		ResultSet rs = null;
		
		//update (4)
		
		String sql = " update product " + " set p_price = 2001 " + " where p_code = 201 ";
				 //치토스 가격이 2000원으로 오름. //set에 앞에 공백을해야 set을 인식.
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); //insert, update, delete 할때 쓰는 메소드. r갯수 호출함.
			if ( r > 0) {
				System.out.println(r + "건 등록됨.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//insert (3)
		String sql1 = " insert into product (p_code, p_name, p_price) "
				+ " values(201, '치토스', 1000) ";
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql1); //insert, update, delete 할때 쓰는 메소드. r갯수 호출함.
			if ( r > 0) {
				conn.commit();
				System.out.println(r + "건 등록됨.");
			} else {
				conn.rollback(); //자동커밋 등록안하면 안되게.
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//두번 실행 -> ORA-00001: 무결성 제약 조건(SCOTT.SYS_C008341)에 위배됩니다 primary key는 중복불가니까.
		
		try { //(2)
//			stmt = conn.createStatement(); //쿼리문 사용하려고 statement 생성
			rs = stmt.executeQuery("select * from product"); // 실행할 쿼리입력 -> resultset에 저장
			System.out.println("상품코드 상품이름        가격");
			System.out.println("-----------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("p_code") // 첫번째 컬럼이 int 타입 p_code.
						+ rs.getString("p_name") + rs.getInt("p_price"));

			}
			System.out.println("------end of rows-------");
		} catch (SQLException e) {
			e.printStackTrace();

		} // end while

		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// end Main
}// end DatabaseExe
