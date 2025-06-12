package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//정렬순서(order)
		String order = req.getParameter("order");
		//order가 널일경우 서버오류 처리  -- 정렬 초기값을 member_id로 설정
		order = order == null ? "member_id" : order;
		
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList(order);
		req.setAttribute("memberList", list);
		
		// 출력 JSP DB에서 loginControl에서 권한에 따른 페이지 이동이 일어남
		req.getRequestDispatcher("admin/memberList.tiles").forward(req,resp);
		
	}

}
