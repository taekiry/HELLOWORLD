package PrivateProject;

public class DriveList {
	
	//필드
	String sort;
	String numPlate;
	String cName;
	int dMile;
	
	public DriveList() {}
	
	public DriveList(String sort, String numPlate, String cName, int dMile) {
		this.sort = sort;
		this.numPlate = numPlate;
		this.cName = cName;
		this.dMile = dMile;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getNumPlate() {
		return numPlate;
	}

	public void setNumPlate(String numPlate) {
		this.numPlate = numPlate;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getdMile() {
		return dMile;
	}

	public void setdMile(int dMile) {
		this.dMile = dMile;
	}
	
	
}
