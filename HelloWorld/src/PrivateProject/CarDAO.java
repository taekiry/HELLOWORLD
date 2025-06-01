package PrivateProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarDAO extends DAO {
	// 1-1. 출차
	public int start(DriveList dlt) {
		String sql = "insert into drive_list(sort" + "                     ,num_plate" + "                      ,c_name"
				+ "                      ,d_mile" + "                      ,isexist)"
				+ " select c.sort, c.num_plate, ?,0,0" + " from car_tbl c" + " where SUBSTR(c.num_plate,-4,4) = ?";

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
	}// end start

	public int start1(DriveList dlt) {
		String sql = " update car_tbl " + " set isexist = 0 " + " where  SUBSTR(num_plate,-4,4) = ?"
				+ " and isexist = 1";

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
	}// end start1

	// 1-2. 입차

	public int end(DriveList end) {
		String sql = "update drive_list" + "    set  isexist = 1 ," + "          d_mile = ? ," + "         accident = ?"
				+ "    where SUBSTR(num_plate,-4,4) = ?" + "    and isexist = 0";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, end.getdMile());
			psmt.setInt(2, end.getAccident());
			psmt.setString(3, end.getNumPlate());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;

	}// end

	public int end1(DriveList end) {

		String sql = " update car_tbl" + " set isexist = 1" + " where  SUBSTR(num_plate,-4,4) = ?" + "and isexist = 0";
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
			while (rs.next()) {
				DriveList dl = new DriveList();
				dl.setNumPlate(rs.getString("num_plate"));
				dl.setcName(rs.getString("c_name"));
				dl.setdMile(rs.getInt("d_mile"));
				dl.setIsExist(rs.getInt("isexist"));
				dl.setAccident(rs.getInt("accident"));
				// 추가
				driveL.add(dl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driveL;
	}

	// 2. 등록
	public int insert(Car car) {

		String sql = "insert into Car_tbl(sort" + "                      ,type" + "                      ,num_plate"
				+ "                      ,price" + "                      ,mile" + "                      ,insurance"
				+ "                      ,isexist" + "                      ,accident)" + "   values (?,?,?,?,?,?,?,?)";
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

	// 3. 목록
	public List<Car> selectDefault() {

		String sql = "select * from car_tbl";
		getConnect();
		List<Car> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				car.setSort(rs.getString("sort"));
				car.setNumPlate(rs.getString("num_plate"));
				car.setIsExist(rs.getInt("isexist"));
				
				list.add(car); // SQL 뷰와 비슷한 느낌.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
		public List<Car> selectPrice() {
			String sql2 = " select * from car_tbl"
					+ " order by PRICE DESC ";

			getConnect();
			List<Car> list2 = new ArrayList<>();
			try {
				psmt = conn.prepareStatement(sql2);
				rs = psmt.executeQuery();
				while (rs.next()) {
					Car car = new Car();
					car.setSort(rs.getString("sort"));
					car.setNumPlate(rs.getString("num_plate"));
					car.setPrice(rs.getInt("price"));
					
					list2.add(car); // SQL 뷰와 비슷한 느낌.
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list2;
	}
			public List<Car> selectAccident() {

				String sql3 ="select * from car_tbl"
						+ " order by 8 DESC";
				getConnect();
				List<Car> list3 = new ArrayList<>();
				try {
					psmt = conn.prepareStatement(sql3);
					rs = psmt.executeQuery();
					while (rs.next()) {
						Car car = new Car();
						car.setSort(rs.getString("sort"));
						car.setNumPlate(rs.getString("num_plate"));
						car.setAccident(rs.getInt("accident"));
						
						list3.add(car); // SQL 뷰와 비슷한 느낌.
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return list3;

	}// end select
		// 3-1 상세목록

	public CarInfo carInfo(String numPlate) {
		String sql = "select  d.sort \"차종\", " + "        c.type AS \"대소\", " + "        d.num_plate AS \"번호판\", "
				+ "        c.mile + sum(d.d_mile)  AS \"총주행거리\", "
				+ "        c.accident + sum(d.accident) As \"사고이력\", "
				+ "        decode(c.type,'대형',300000,'소형',150000) + (sum(d.accident)+c.accident)*100000 AS \"보험료\",\r\n"
				+ "        c.price  - (sum(d.accident) + c.accident) * 100000 - (sum(d.d_mile) + c.mile) * (sum(d.accident) + c.accident) * 88 \"현재가치\"\r\n"
				+ "from drive_list d join car_tbl c\r\n" + "                  on d.num_plate = c.num_plate\r\n"
				+ "WHERE SUBSTR(d.num_plate,-4,4) = ?\r\n"
				+ "GROUP BY d.sort,c.type,d.num_plate,c.mile,c.accident,c.price";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, numPlate);
			rs = psmt.executeQuery();
			if (rs.next()) {
				CarInfo cInfo = new CarInfo();
				cInfo.setSort(rs.getString(1));
				cInfo.setType(rs.getString(2));
				cInfo.setNumPlate(rs.getString(3));
				cInfo.setTotalMile(rs.getInt(4));
				cInfo.setAccidentNum(rs.getInt(5));
				cInfo.setInsurance(rs.getInt(6));
				cInfo.setPv(rs.getInt(7));
				return cInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

	// 4 . 삭제
	public int delete(String numPlate) {

		String sql = "delete from car_tbl" + "   where SUBSTR(num_plate,-4,4) = ?";
		// 접속.
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

	public CustomerInfo customInfo(String cName) {

		String sql = "SELECT C_Name,\r\n" 
				+ "       COUNT(C_NAME),\r\n"
				+ "       SUM(D_MILE),\r\n"
				+ "       SUM(ACCIDENT)\r\n"
				+ "FROM   DRIVE_LIST\r\n"
				+ "WHERE  C_NAME = ?\r\n"
				+ "GROUP BY C_NAME";

		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cName);
			rs = psmt.executeQuery();
			if(rs.next()) {
				CustomerInfo customInfo = new CustomerInfo();
				customInfo.setcName(rs.getString(1));
				customInfo.setCount(rs.getInt(2));
				customInfo.setTotalMile(rs.getInt(3));
				customInfo.setTotalAcc(rs.getInt(4));
				return customInfo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}

}// end CarDAO
