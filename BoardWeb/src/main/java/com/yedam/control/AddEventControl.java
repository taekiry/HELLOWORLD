package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.EventVO;

public class AddEventControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVO evo = new EventVO();
		evo.setTitle(title);
		evo.setStart(start);
		evo.setEnd(end);
		
		
		BoardService svc = new BoardServiceImpl();
		Map<String, Object> map = new HashMap<>();

		if(svc.addEvent(evo)) {
			map.put("retCode", "Success");
			map.put("retVal", evo);
		} else {
			map.put("retCode", "Fail");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		resp.getWriter().print(json);
	}
}
