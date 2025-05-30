package PrivateProject;

public class CarInfo {
	String sort;
	String type;
	String numPlate;
	int totalMile;
	int accidentNum;
	int insurance;
	int pv;
	
	public CarInfo() {}
	
	public CarInfo(String sort, String type, String numPlate, int totalMile, int accidentNum, int insurance, int pv) {
		super();
		this.sort = sort;
		this.type = type;
		this.numPlate = numPlate;
		this.totalMile = totalMile;
		this.accidentNum = accidentNum;
		this.insurance = insurance;
		this.pv = pv;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumPlate() {
		return numPlate;
	}

	public void setNumPlate(String numPlate) {
		this.numPlate = numPlate;
	}

	public int getTotalMile() {
		return totalMile;
	}

	public void setTotalMile(int totalMile) {
		this.totalMile = totalMile;
	}

	public int getAccidentNum() {
		return accidentNum;
	}

	public void setAccidentNum(int accidentNum) {
		this.accidentNum = accidentNum;
	}

	public int getInsurance() {
		return insurance;
	}

	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	
	
}
