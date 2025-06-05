package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/servlet/boardList.serv") //url 경로 설정
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardList() {
    }

    //request -> 서버로 요청정보 보내기위해 객체생성/ response -> 서버가 웹브라우저로 응답정보 송신하기위해 객체생성.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h3>hello<h3>");
		out.print("<p>나는 한글<p>");
	   // SqlSession sqlSession = DataSource.getInstance().openSession();
		//response.getWriter().append("Served at: hello ").append(request.getContextPath());
	    
	    //인터페이스 - 매퍼.
//	    BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//	    List<BoardVO> list = mapper.selectList();
	    
	    BoardService svc = new BoardServiceImpl();
	    List<BoardVO> list = svc.boardList();
	    
	    out.print("<table border='1'>");
	    out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th>");
	    out.print("<tbody>");
	    for(int i = 0 ; i <list.size(); i++) {
	    	out.print("<tr>");
	    	out.print("<td align='center'>" + list.get(i).getBoardNo() + "</td>");
	    	out.print("<td><a href='../board.serv?bno="+(i+1)+"'>" + list.get(i).getTitle() + "</a></td>");
	    	out.print("<td>" + list.get(i).getWriter() + "</td>");
	    	out.print("</tr>");
	    }
	    out.print("</tbody></table>");
	    
	  //index 페이지로 이동.
	    //out.print("<a href='../index.html'>인덱스페이지</a>");
	    
	    out.print("<a href='../html/addForm.html'>등록페이지</a>");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
