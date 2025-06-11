package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control{

	// TODO id, pw 활용 -> 로그인 기능
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("mid");
		String pw = req.getParameter("pass");
		
		//로그인 기능
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login(id, pw);
		
		//성공여부 체크
		if(member != null) {
			//글등록화면
			//세션객체에 setAttribute("logId", member.memberId)
			HttpSession session = req.getSession();
			
			//request 요청정보 객체에서 서버로 쿠키심어둠 -> 쿠키정보 읽어와서 세션을 만듦 -> 로그인 정보 세션에 저장 
			session.setAttribute("logId", member.getMemberId()); //setAttribute로 세션에 아이디 저장-> 로그인상태유지
			
			//권한에 따라 시작페이지 지정.
			if(member.getResponsibility().equals("User")) {
				resp.sendRedirect("addBoard.do");
			} else if(member.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
		} else {
			//로그인 화면으로이동
			req.setAttribute("msg", "ID와 PW를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
		
	}//end exec

}// end LoginControl
