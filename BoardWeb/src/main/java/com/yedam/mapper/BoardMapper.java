package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

/*
 * 인터페이스 - XML 매칭(패키지이름이 같아야함) ->인터페이스 네임으로 쿼리실행
 */
public interface BoardMapper {
	public List<BoardVO> selectList(); 			//xml에 있는 selectBoard와 동일하게. 모든리스트
	public List<BoardVO> selectListWithPaging(SearchDTO search); // page에 몇개씩 분류해서 모든 리스트
	public int insertBoard(BoardVO board); 	//처리된 건수가 반환되니까 int타입
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	public BoardVO selectBoard(int bno);			//단건조회.
	public int updateReadCnt(int bno);				//조회시 조회수 증가
	//전체 건수
	public int selectCount(SearchDTO search);
	public List<Map> selectUserByCount();			// 작성자 카운트 담고있는 VO만들어도 됨.
}
