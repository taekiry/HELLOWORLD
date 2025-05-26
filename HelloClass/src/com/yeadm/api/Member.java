package com.yeadm.api;

public class Member {
	public String memberName;
	int age;
	
	
	public Member() {}
	
	public Member(String memberName, int age) {
		
		this.memberName = memberName;
		this.age = age;
	}

	
	public String toString1() {
		// TODO Auto-generated method stub
		return toString();
	}

	// 이름, 점수 같으면 논리적으로 동등한지 equals overriding.
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) { 		//매개값 obj가 Member의 instance인가
			Member member = (Member) obj;	//casting 안해주면 .memberName, .age 못씀
			return this.memberName == member.memberName  // equals안에서 글자하나씩 비교됨. ==씀
			&& this.age == member.age;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "이름: " + memberName + ", 나이: " + age;
	}

	@Override
	public int hashCode() { 			//원래 hashCode는 주소값 int로 반환. age를 기준으로 먼저 그룹화하게끔.
										//HashSet 방식 : HashCode로 그룹화 -> equals로 동일한지 비교.
		return age;
	}


}// end Member
