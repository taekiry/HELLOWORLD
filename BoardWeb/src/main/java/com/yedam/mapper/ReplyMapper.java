package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO rvo);
	public List<ReplyVO> selectReplyAll(@Param("bno") int bno, @Param("page") int page);
	public ReplyVO selectReplyOne(int rno);
	public int deleteReply(int rno);
}
