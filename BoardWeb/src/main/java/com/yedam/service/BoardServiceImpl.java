package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public class BoardServiceImpl implements BoardService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); //sqlsession이 맵핑자동으로 해줫기때문에 getMapper가능.
	
	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		return mapper.selectList();			//database 라이브러리 연습하려고 바꿈.
		//return mapper.selectListWithPaging(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		BoardVO board = mapper.selectBoard(bno); //글번호로 조회
		if(board != null) {
			mapper.updateReadCnt(bno);// 글번호 --> 조회수 증가
			sqlSession.commit();
		}
		return board;
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board); //처리된 건수가 반환 r에 저장.
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
		
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		int r = mapper.updateBoard(board);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		int r = mapper.deleteBoard(bno);
		if(r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int getTotalCount(SearchDTO search) {
		int r = mapper.selectCount(search);
		return r;
	}

	@Override
	public List<Map> chartCount() {
		
		return mapper.selectUserByCount();
	}

	@Override
	public List<EventVO> eventList() {
		return mapper.selectEvent();
	}

	@Override
	public boolean addEvent(EventVO evo) {
		 int r = mapper.insertEvent(evo);
		 if(r == 1) {
			 sqlSession.commit();
			 return true;
		 } 
		 return false;
	}

	@Override
	public boolean removeEvent(String title) {
		int r = mapper.deleteEvent(title);
		if( r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}


}
