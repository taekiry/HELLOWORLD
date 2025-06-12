package com.yedam.control;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");  //mapper파일의 쿼리문 page의 parameter
		page = page == null? "1" : page; //boardList.do 의 parameter 없을경우 1페이지 출력.
		
		//
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		kw = kw == null? "": kw;
		sc = sc == null? "": sc;
		kw = URLDecoder.decode(kw); //modify에서 encoding한거 다시 decoding 16진수 -> 한글.
		//검색 조건
		//boardList.do?searchCondition=W&keyword=김 boardList의 parameter가 3개가 되버리기때문에 parameter 3개가진 클래스하나 만듦
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		
		//데이터 처리
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);

		//페이징 계산.
		int totalCnt = svc.getTotalCount(search);
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		//요청정보에 list를 담아서 jsp로 전달.
		req.setAttribute("pageInfo", paging);
		req.setAttribute("blist",list); 
		req.setAttribute("search", search);

		//forward : 포워딩페이지이동. /boardList.do 맵핑해서 BoardListControl이 실행. setAttribute로 데이터 값 저장 -> forward로 데이터 JSP로 전송.
		
		HttpSession session = req.getSession(); //loginControl에서 session에 setAttribute로 권한값도 저장했음
		String auth = (String) session.getAttribute("auth");
		if(/*일반사용자(회원)*/ auth != null && auth.equals("User")) {
			req.getRequestDispatcher("user/boardList.tiles").forward(req, resp); //user는 폴더x definition임
		}
		else if(/*관리자*/auth != null &&  auth.equals("Admin")) {
			req.getRequestDispatcher("admin/board/boardList.tiles").forward(req, resp); //관리자로 로그인시 실행됨.
		} else { //guest일 경우
			req.getRequestDispatcher("user/boardList.tiles").forward(req, resp); 
		}
		
		
	}//end exec
	
}//end BoardlistControl
