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
		return dao.select();
	}


	@Override
	public boolean startDrive(String cName, String numPlate) {
		return dao.start(cName, numPlate) == 1;
	}

	@Override
	public boolean endDrive(String numPlate) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
