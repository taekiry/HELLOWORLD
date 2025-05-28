package PrivateProject;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CarDAO extends DAO {
	//1. 출차
	public int start(String cName, String numPlate) {
		String sql = "update car_tbl\r\n"
				+ "    set    isExist = 0,\r\n"
				+ "           Mile = Mile + 1000\r\n"
				+ "    where SUBSTR(num_plate,-4,4) = ?\r\n";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, numPlate);
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	
	// 3. 등록
	public int insert(Car car) {
		
		String sql = "insert into Car_tbl(sort"
				+ "                      ,type"
				+ "                      ,num_plate"
				+ "                      ,price"
				+ "                      ,mile"
				+ "                      ,insurance"
				+ "                      ,isexist)"
				+ "   values (?,?,?,?,?,?,?)";
		// 접속.
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, car.getSort());
			psmt.setString(2, car.getType());
			psmt.setString(3, car.getNumPlate());
			psmt.setInt(4, car.getPrice());
			psmt.setInt(5, car.getMile());
			psmt.setString(6, car.getInsurance());
			psmt.setInt(7, car.getIsExist());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	//4. 목록
	public List<Car> select() {
		
		String sql = "select * from car_tbl";
		getConnect();
		List<Car> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Car car = new Car();
				car.setSort(rs.getString("sort")); 
				car.setNumPlate(rs.getString("num_plate"));
				car.setIsExist(rs.getInt("isexist"));
				//추가
				list.add(car); //SQL 뷰와 비슷한 느낌.
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return list;
		
		
	}
	
	//5. 삭제
	public int delete(String numPlate) {
		
		String sql = "delete from car_tbl"
				+ "   where SUBSTR(num_plate,-4,4) = ?";
		//접속.
		getConnect();
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, numPlate);
			int r = psmt.executeUpdate();
			return r; //건수반환.
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); 
		}
		return 0;
	}
}// end CarDAO
