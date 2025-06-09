package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		String boardNo = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		if(req.getMethod().equals("GET")) { //get요청이면 화면 open / modifyBoard.do?bno=23 을 실행
			
			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			req.setAttribute("board", board);
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
			
		} else if(req.getMethod().equals("POST")) { //post요청이면 Data저장.
			
			BoardVO board = new BoardVO();
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			if(svc.modifyBoard(board)) {
				System.out.println("수정성공");
				resp.sendRedirect("boardList.do"); //매개값x 페이지만 보여줄때 forward랑 다른점.
			}
		}
		
	}//end exec

}// end ModifyBoardControl
