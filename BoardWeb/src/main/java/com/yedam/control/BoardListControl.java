package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.setCharacterEncoding("utf-8");
		
//	연습	req.setAttribute("myName","Hongkildong");
		
		String page = req.getParameter("page");  //mapper파일의 쿼리문 page의 parameter
		page = page == null? "1" : page; //boardList.do 의 parameter 없을경우 1페이지 출력.
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));

		//페이징 계산.
		int totalCnt = 112;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("pageInfo", paging);
		
		req.setAttribute("blist",list); //요청정보에 list를 담아서 jsp로 전달.
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
		//forward : 페이지이동. /boardList.do 맵핑해서 BoardListControl이 실행.
		
	
		
		
	}//end exec
	
}//end BoardlistControl
