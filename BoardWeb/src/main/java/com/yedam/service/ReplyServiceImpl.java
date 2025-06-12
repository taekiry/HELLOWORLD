package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVO rvo) {
		int r = mapper.insertReply(rvo);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<ReplyVO> replyList(int bno) {
		return mapper.selectReplyAll(bno);
	}

	@Override
	public ReplyVO getReply(int rno) {
		return mapper.selectReplyOne(rno);
	}

	@Override
	public boolean removeReply(int rno) {
		int r = mapper.deleteReply(rno);
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

}
