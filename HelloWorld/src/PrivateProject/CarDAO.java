package PrivateProject;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CarDAO extends DAO {
	//1-1. 출차
	public int start(DriveList dlt) {
		String sql = "insert into drive_list(sort"
				+ "                     ,num_plate"
				+ "                      ,c_name"
				+ "                      ,d_mile"
				+ "                      ,isexist)"
				+ " select c.sort, c.num_plate, ?,0,0"
				+ " from car_tbl c"
				+ " where SUBSTR(c.num_plate,-4,4) = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dlt.getcName());
			psmt.setString(2, dlt.getNumPlate());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}//end start
	
	public int start1(DriveList dlt) {
		String sql	= " update car_tbl "
				+ " set isexist = 0 "
				+ " where  SUBSTR(num_plate,-4,4) = ?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dlt.getNumPlate());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}//end start1
	
	//1-2. 입차
	
	public int end( DriveList end) {
		String sql =  "update drive_list"
				+ "    set  isexist = 1,"
				+ "          d_mile = ?,"
				+ "         accident = ?"
				+ "    where SUBSTR(num_plate,-4,4) = ?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, end.getdMile());
			psmt.setInt(2, end.getAccident());
			psmt.setString(3, end.getNumPlate());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
		
	}// end
	public int end1( DriveList end) {
		
		String sql	= " update car_tbl"
				+ " set isexist = 1"
				+ " where  SUBSTR(num_plate,-4,4) = ?";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, end.getNumPlate());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	// 출입명부
	public List<DriveList> driveL() {
		String sql = " select * from drive_list ";
		getConnect();
		List<DriveList> driveL = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				DriveList dl = new DriveList();
				dl.setNumPlate(rs.getString("num_plate"));
				dl.setcName(rs.getString("c_name"));
				dl.setdMile(rs.getInt("d_mile"));
				dl.setIsExist(rs.getInt("isexist"));
				dl.setAccident(rs.getInt("accident"));
				//추가
				driveL.add(dl);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return driveL;
	}
	
	// 2. 등록
	public int insert(Car car) {
		
		String sql = "insert into Car_tbl(sort"
				+ "                      ,type"
				+ "                      ,num_plate"
				+ "                      ,price"
				+ "                      ,mile"
				+ "                      ,insurance"
				+ "                      ,isexist"
				+ "                      ,accident)"
				+ "   values (?,?,?,?,?,?,?,?)";
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
			psmt.setInt(8, car.getaccident());
			int r = psmt.executeUpdate();
			return r; // 건수반환.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	//3. 목록
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
		
	}// end select
	//3-1 상세목록
	
	public int showInfo(DriveList dlt);
		String sql = 
	
	//4	. 삭제
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
