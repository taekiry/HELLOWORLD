package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AllControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("product/productList.tiles").forward(req,resp);
		// tiles를 호출 -> tiles.xml에 와일드카드 */*로 설정해둬서 템플릿 적용됨.
	}

	
}
