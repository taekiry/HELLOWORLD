package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService { // 개인프로젝트 차량 출차시 출입명부에 등록 + carlist에 출차 처리되는거처럼 
								// 업무 ,service 단위로 묶음. 
	public List<BoardVO> boardList(SearchDTO search);  //목록조회.
	public BoardVO getBoard(int bno);
	public boolean registerBoard(BoardVO board);	//mapper에서는 등록,삭제,업데이트가 int타입으로 고정
	public boolean modifyBoard(BoardVO board);
	public boolean removeBoard(int bno);
	//전체 글수 계산.
	public int getTotalCount(SearchDTO search); // selectCount() mapper쪽에
	
}
