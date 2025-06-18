package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {

	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	//쿼리문 안에서 쓰는 변수 이름을 가르킬때 @Param -> 쿼리안에서 parameterType 지정할필요 x
	
	public List<MemberVO> selectList(@Param("order") String order);
	
	//회원 추가
	public int insertMember(MemberVO member);
	
	//회원 아이디 체크
	public MemberVO selectMemberInfo(String id);
}
