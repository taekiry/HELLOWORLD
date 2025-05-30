package PrivateProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	//필드
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		Connection conn = null;
		Statement stmt;
		public PreparedStatement psmt;			//Statement 쓰기 불편해서
		ResultSet rs;
		
		//Connection 반환하는 메소드.
		public void getConnect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");//클래스가 있는지 check;
				conn = DriverManager.getConnection(url, id, pass);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}//end getConnect
		
		public void disConnect() {
			try {
				if(conn != null) conn.close();
				if(stmt != null) stmt.close();
				if(rs != null) rs.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
			
		}//end disConnect
		
}//end Dao
