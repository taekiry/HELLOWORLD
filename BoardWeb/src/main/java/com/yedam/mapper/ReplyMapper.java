package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO rvo);
	public List<ReplyVO> selectReplyAll(int bno);
	public ReplyVO selectReplyOne(int rno);
	public int deleteReply(int rno);
}
