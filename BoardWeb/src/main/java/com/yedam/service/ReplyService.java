package com.yedam.service;
// 추가, 목록, 단건조회, 삭제

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	public boolean addReply(ReplyVO rvo);
	public List<ReplyVO> replyList(int bno, int page);
	public ReplyVO getReply(int rno);
	public boolean removeReply(int rno);
	public int totalCount(int bno);

}
