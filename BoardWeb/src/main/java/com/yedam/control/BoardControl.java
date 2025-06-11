package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class BoardControl implements Control {


	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		// 단건 조회 http://localhost:8080/BoardWeb/board.do?bno=12 -> ? : parameter 전달.
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		// 파라메타 추가 (page, searchCondition, keyword)
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		req.setAttribute("board", board);
		
	
		
		req.getRequestDispatcher("user/board.tiles").forward(req, resp);
	}
	
}
