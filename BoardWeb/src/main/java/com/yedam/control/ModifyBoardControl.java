package com.yedam.control;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String bno = req.getParameter("bno");

		String pg = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		sc = sc == null? "": sc;
		String kw = req.getParameter("keyword");
		kw = kw == null? "": kw;
		BoardService svc = new BoardServiceImpl();

		if (req.getMethod().equals("GET")) { // get요청이면 화면 open / modifyBoard.do?bno=23 을 실행

			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			req.setAttribute("board", board);

			req.setAttribute("page", pg);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);

			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) { // post요청이면 Data저장.

			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);

			svc.modifyBoard(board);

			//resp.sendRedirect("boardList.do?page=" + 1 + "&searchCondition=" + "T" + "&keyword=" + "오즈"); // 매개값x 페이지만
			//keyword에 한글 값 16진수로 받아져서 URLEncoder사용																							// 보여줄때 forward랑
			String encodedKeyword = URLEncoder.encode(kw, "UTF-8");
			String encodedKeyword2 = URLEncoder.encode(sc, "UTF-8");
			String redirectURL = "boardList.do?page=" + pg + 
			                     "&searchCondition=" + encodedKeyword2 + 
			                     "&keyword=" + encodedKeyword;		
			// 다른점.
			resp.sendRedirect(redirectURL);
		}

	}// end exec

}// end ModifyBoardControl