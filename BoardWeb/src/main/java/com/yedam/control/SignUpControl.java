package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class SignUpControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		req.setCharacterEncoding("utf-8");
		
		// GET 요청 = 화면출력
		// POST 요청 = 회원등록.
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("member/signUp.tiles").forward(req,resp);
			
		} else if(req.getMethod().equals("POST")) {
			//DB에도 insert 되고, 회원가입 누를시 images폴더에 img파일이 업로드도 되야함.
			//images 업로드
			//1. 요청정보 2. 업로드할 경로 3.파일의 최대크기 4.인코딩 5.리네임정책(서버에 같은 이름있다고 overwriting하지 않게)
			String savePath = req.getServletContext().getRealPath("images"); //webapp이 최상위 그안에 바로 images폴더
			MultipartRequest mr = new MultipartRequest(
					req, 		 	//요청정보
					savePath,	 	//경로
					1024 * 1024 * 5, //최대크기(5MB)
					"UTF-8",		//인코딩
					new DefaultFileRenamePolicy() //리네임 정책
					);
			
			String id = mr.getParameter("userId");
			String pw = mr.getParameter("userPw");
			String name = mr.getParameter("userName");
			
			String img = mr.getFilesystemName("userImg");
			
			//parameter 세팅
			MemberVO member = new MemberVO();
			member.setMemberId(id);
			member.setMemberName(name);
			member.setPassword(pw);
			member.setImg(img);
			
			if(svc.addMember(member)) {
				resp.sendRedirect("boardList.do");
			} 
			
			
		}
		
	}//end exec

}// end class
