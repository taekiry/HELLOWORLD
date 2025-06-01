package PrivateProject;

public class CustomerInfo {
	String cName;
	int count;
	int totalMile;
	int totalAcc;
	
	public CustomerInfo() {}
	
	public CustomerInfo(String cName, int count, int totalMile, int totalAcc) {
		
		this.cName = cName;
		this.count = count;
		this.totalMile = totalMile;
		this.totalAcc = totalAcc;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalMile() {
		return totalMile;
	}

	public void setTotalMile(int totalMile) {
		this.totalMile = totalMile;
	}

	public int getTotalAcc() {
		return totalAcc;
	}

	public void setTotalAcc(int totalAcc) {
		this.totalAcc = totalAcc;
	}
	
	
}
