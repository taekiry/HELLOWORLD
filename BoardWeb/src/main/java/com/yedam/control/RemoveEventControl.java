package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class RemoveEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");

		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVO evo = new EventVO();
		evo.setEnd(end);
		evo.setStart(start);
		evo.setTitle(title);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(title);

		BoardService svc = new BoardServiceImpl();
		

		if (svc.removeEvent(evo)) {
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\" : \"Fail\"}");
		}
		

	}

}
