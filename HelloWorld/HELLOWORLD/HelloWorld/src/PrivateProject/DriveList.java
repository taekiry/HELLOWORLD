package PrivateProject;

public class DriveList {
	
	//필드
	String numPlate;
	String cName;
	int dMile;
	int isExist;
	int accident;
	
	public DriveList() {}

	public DriveList( int dMile,int accident,String numPlate) {
		this.numPlate = numPlate;
		this.dMile = dMile;
		this.accident = accident;
				
	}
	
	public DriveList(String numPlate, String cName) {

		
		this.numPlate = numPlate;
		this.cName = cName;
		
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

	public int getIsExist() {
		return isExist;
	}

	public void setIsExist(int isExist) {
		this.isExist = isExist;
	}
	
	public int getAccident() {
		return accident;
	}
	public void setAccident(int accident) {
		this.accident = accident;
	}
	
	@Override
	public String toString() {
		return "DriveList [numPlate=" + numPlate + ", cName=" + cName + ", dMile=" + dMile + ", isExist=" + isExist
				+ ", accident=" + accident + "]";
	}
	
}
