package PrivateProject;

import java.util.List;

/*
 * 업무로직(등록, 변경, 삭제, 출력)
 */
public interface CarService {
	
	public boolean addCar(Car car);
	public List<Car> carList();
	public boolean removeCar(String numPlate);
	public boolean startDrive(DriveList dlt);
	public boolean endDrive(DriveList dlt);
	public List<DriveList> driveList();
	
}
