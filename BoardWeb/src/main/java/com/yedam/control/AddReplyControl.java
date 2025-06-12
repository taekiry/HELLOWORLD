package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control{
	//댓글 등록. 원본글번호, 댓글작성자, 댓글
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8"); //반환 타입: json문자열
		
		String bno = req.getParameter("bno");      // 원본 글 번호 ?뒤에 url에 직접쳐야함 아직
		String reply = req.getParameter("reply");  // 댓글 내용
		String replyer = req.getParameter("replyer");  // 댓글 작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		//DB처리
		ReplyService svc = new ReplyServiceImpl();
		
		if(svc.addReply(rvo)) {
			//{"retCode" : "Success"} returnCode  .print(""안에 복붙)
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {
			//{"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
		
	}

}
