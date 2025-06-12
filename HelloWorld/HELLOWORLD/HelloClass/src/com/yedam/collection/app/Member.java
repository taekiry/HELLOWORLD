package com.yedam.collection.app;

/*
 * 항목(아이디, 이름, 전화번호, 포인트)
 * - 아이디 : admin, guest, limp1, user01
 * - 이름 : 홍길동, 김말숙
 * - 전화번호 : 010-1212-3434
 * - 포인트 : 10000
 */

	public class Member {          
		private String memberId;
		public String memberName;
		private String phone;
		private int point;
	

	//메소드 값을 필드로 지정 (setter)/ 속성값을 반환 (getter)
	

//	void setMemberId (String memberId) {
//		this.memberId = memberId;
//	}
//	String getMemberId() {
//		return memberId;
//	}
//	
//	void setMemberName (String memberName) {
//		this.memberName = memberName;
//	}
//	String getMemberName() {
//		return memberName;
//	}
//	
//	void setPhone (String phone) {
//		this.phone = phone;
//	}
//	String getPhone() {
//		return phone;
//	}
//	
//	void setPoint (int point) {
//		this.point = point;
//	}
//	int getPoint() {
//		return point;
//	}
	
	
	//생성자 지정안하면 기본생성자
	//클래스 멤버 : 클래스에 선언되는 멤버들 -> 필드, 생성자, 메소드
	//전체 필드를 매개값으로 갖는 생성자.-eclipse 제공
	//우클릭 -> source -> construct using fields (alt + shift + s로 가능)
	
	public Member() {
		
	}
		
	public Member(String memberId, int point) {
		
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}

	

	public Member(String memberId, String memberName, String phone, int point) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.phone = phone;
		this.point = point;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	//이름,연락처,포인트 출력 메소드
	public void showInfo(Member member) {
		System.out.printf("이름: %s\n연락처: %s\n포인트: %d",member.getMemberName(),member.getPhone(),member.getPoint());
	}

}//end class