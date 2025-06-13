package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control{
	//댓글 등록. 원본글번호, 댓글작성자, 댓글
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8"); //반환 타입: json문자열
		
		String bno = req.getParameter("bno");      // 원본 글 번호 ?뒤에 url에 직접쳐야함 아직
		String reply = req.getParameter("reply");  // 댓글 내용
		String replyer = req.getParameter("replyer");  // 댓글 작성자
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		//Map형식으로 담아서 retCode와 success or fail, retVal에 객체로 rvo도 보내려고
		Map<String, Object> map = new HashMap<>();
		// java 객체 -> json 문자열
		Gson gson = new GsonBuilder().create();
		
		//DB처리
		ReplyService svc = new ReplyServiceImpl();
		
		if(svc.addReply(rvo)) {
			//{"retCode" : "Success"} returnCode  .print(""안에 복붙)
			map.put("retVal", rvo); 		//자바객체도 담아서 보내면 rno도 같이 보낼수 있어서
			map.put("retCode", "Success");
			//resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {
			//{"retCode" : "Fail"}
			//resp.getWriter().print("{\"retCode\" : \"Fail\"}");
			map.put("retCode", "Fail");
		}
		String json = gson.toJson(map);
		System.out.println(json);
		resp.getWriter().print(json);
	}

}
