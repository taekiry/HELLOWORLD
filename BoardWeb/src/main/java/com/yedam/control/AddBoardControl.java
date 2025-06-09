package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글 처리
		req.setCharacterEncoding("utf-8");
		

		// 요청방식 Get or Post 구분 처리.
		if (req.getMethod().equals("GET")) { //url에다가 enter치는 방식
			// WEB-INF/jsp/addBoard.jsp Control을 통해서 실행
			req.getRequestDispatcher("WEB-INF/jsp/addBoard.jsp").forward(req, resp); 
			// 현재페이지는 addBoard.do로 머물러야하지만 요청하는 페이지를 재지정하겠습니다. (포워드 메소드)
		} else if (req.getMethod().equals("POST")) { //vs Code 활용한 form 태그에 메소드를 활용 -> method ="post"
			// POST 요청
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			// 메소드의 매개값
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);

			// 업무 서비스
			BoardService svc = new BoardServiceImpl();
			if (svc.registerBoard(board)) {
				System.out.println("등록성공.");
				// 목록페이지로 이동.
				resp.sendRedirect("boardList.do");
			} else {
				System.out.println("등록실패.");
			}
			
		}
		
	}
	
}//end of class