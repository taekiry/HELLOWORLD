package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//forward : 페이지이동. /boardList.do 맵핑해서 BoardListControl이 실행.
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
		
	
		
		
	}//end exec
	
}//end BoardlistControl
