package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardService svc = new BoardServiceImpl();
		String bno = req.getParameter("bno");
		if(req.getMethod().equals("GET")) { //get요청이면 화면 open / 
		
			if(svc.removeBoard(Integer.parseInt(bno))) {;
				System.out.println("삭제 성공");
				resp.sendRedirect("boardList.do");
			}
		}
	}
	
}
