package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rno로 삭제

		String rno = req.getParameter("rno");

		ReplyService svc = new ReplyServiceImpl();

		if (svc.removeReply(Integer.parseInt(rno))) {
			// {"retCode" : "Success"} returnCode .print(""안에 복붙)
			resp.getWriter().print("{\"retCode\" : \"Success\"}"); //"{"retCode" : "Success"}": JSON 형식의 문자열을 직접 작성해서 보냄
		} else {
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}

	}

}
