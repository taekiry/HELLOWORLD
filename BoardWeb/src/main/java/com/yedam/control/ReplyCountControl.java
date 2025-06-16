package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 글번호에 대한 댓글건수 반환
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl(); //totalCount
		int totalCnt = svc.totalCount(Integer.parseInt(bno));
		
		// ex) {"totalCnt": 27} 형식으로 ""안에다 복붙. => json 문자열로 반환
		resp.getWriter().print("{\"totalCnt\": " + totalCnt + "}");
	}

}
