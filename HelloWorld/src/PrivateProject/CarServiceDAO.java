package PrivateProject;

import java.util.List;

public class CarServiceDAO implements CarService {
	CarDAO dao = new CarDAO();

	@Override
	public boolean addCar(Car car) {

		return dao.insert(car) == 1;
	}

	@Override
	public boolean removeCar(String numPlate) {

		return dao.delete(numPlate) == 1;
	}

	@Override
	public List<Car> carList() {
		return dao.selectDefault();
	}
	public List<Car> carListPrice() {
		return dao.selectPrice();
	}
	public List<Car> carListAccident() {
		return dao.selectAccident();
	}

	@Override
	public boolean startDrive(DriveList dlt) {
		return dao.start(dlt) == 1 && dao.start1(dlt) == 1;
	}

	@Override
	public boolean endDrive(DriveList dlt) {
		return dao.end(dlt) == 1 && dao.end1(dlt) == 1;
	}

	@Override
	public List<DriveList> driveList() {
		
		return dao.driveL();
	}

	@Override
	public List<CarInfo> carInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarInfo showInfo(String numPlate) {
		
		return dao.carInfo(numPlate);
	}

	@Override
	public CustomerInfo customInfo(String cName) {
		
		return dao.customInfo(cName);
	}


}
