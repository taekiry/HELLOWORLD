package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
/* Model, View(jsp), Control
 * M.V.C 중 Controller //mvc pattern2 -> controller servlet // mvc patter1 -> jsp로 servlet
 * url패턴 - 실행서블릿 (key, value)형식으로 관리.
 * frontController는 서블릿.
 */
public class FrontController extends HttpServlet{
	//필드
	Map<String, Control> map;

	//생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	//메소드
	@Override //서버실행하면 한번만 init
	public void init(ServletConfig config) throws ServletException {
		//boardList.do(url) -> 글 목록 출력 기능.
		map.put("/boardList.do", new BoardListControl());   //글 목록
		map.put("/board.do", new BoardControl());			//글 상세
		map.put("/addBoard.do", new AddBoardControl());	    //글 추가
		map.put("/modifyForm.do", new ModifyBoardControl());      //글 수정
		map.put("/removeBoard.do", new RemoveBoardControl());      //글 삭제
	//member관련
		map.put("/loginForm.do", new LoginFormControl());	//로그인 화면
		map.put("/login.do", new LoginControl()); 			//id,pw 로그인 처리
		map.put("/logout.do", new LogoutControl());
	//회원 목록	
		map.put("/memberList.do", new MemberListControl());
	}
	
	//
	@Override //url 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 -> url중에서 ~.do를 파악 -> 그에맞는 control 반환.
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); //uri : 8080뒤부터 끝까지.(BoardWeb/boardList.do)
		String context = req.getContextPath(); //다른 프로젝트 /helloworld -> 11자라서 substring시 9로는 출력안됨.
		String page = uri.substring(context.length());//BoardWeb/ 삭제
		Control sub = map.get(page); //map.get -> key 반환해주는 메소드
		sub.exec(req,resp);
		
	}
	
}
