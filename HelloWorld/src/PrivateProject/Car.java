package PrivateProject;

import java.util.Date;

/*
 * 필드 / 생성자/ 메소드.
 */
public class Car {

	//필드
	String sort;
	String type;
	String numPlate;
	int price;
	int mile;
	String insurance;
	int isExist = 1;
	int accident;
	
	//생성자
	public Car() {}
	
	public Car(String sort, String type, String numPlate, int price, int mile, String insurance, int isExist, int accident) {
		
		this.sort = sort;
		this.type = type;
		this.numPlate = numPlate;
		this.price = price;
		this.mile = mile;
		this.insurance = insurance;
		this.isExist = isExist;
		this.accident = accident;
		
	}
	//getter & setter
	
	public Car(String sort2, String type2, String numPlate2, int price2, int mile2, String insurance2, int accident) {
		this.sort = sort2;
		this.type = type2;
		this.numPlate = numPlate2;
		this.price = price2;
		this.mile = mile2;
		this.insurance = insurance2;
		this.accident = accident;
		
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMile() {
		return mile;
	}
	public void setMile(int mile) {
		this.mile = mile;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public int getIsExist() {
		return isExist;
	}
	public void setIsExist(int isExist) {
		this.isExist = isExist;
	}
	public int getaccident() {
		return accident;
	}
	public void setAccident(int accident) {
		this.accident = accident;
	}
	//sort + "    " + numPlate + "     "+ (isExist==0?"출차":"입차");
	@Override
	public String toString() {
		return sort + "    " + numPlate + "     "+ (isExist==0?"출차":"입차");
	}
}//end Car
