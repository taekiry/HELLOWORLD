package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/*
 * 클래스가 서블릿이 되는 순서
 * HttpServlet을 상속
 * 생성자 선언
 * init() 메소드 (반드시필요 x)
 * service() 메소드 (반드시 필요 o)
 * url 등록("board.serv")
 * 
 * run as server -> 처음엔 생성자 init service순으로 호출 
 * 그다음부터는 service메소드만 호출.
 */


@WebServlet("/board.serv")

public class BoardServlet extends HttpServlet {
	
	//생성자(기능 x 호출되는지만보게)
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출");
	}
	//init() 메소드.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	//service()메소드.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8"); //컨텐트 타입 지정.
		System.out.println("service 메소드 호출");
		SqlSession sqlSession = DataSource.getInstance().openSession(true); //openSession() -> true : 자동 commit
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		//요청할 페이지의 parameter ?bno=3 3번글 조회하려고.
		String boardNo = req.getParameter("bno"); //매우매우중요
		
		//상세조회
		BoardVO board = mapper.selectBoard(Integer.parseInt(boardNo));
		//조회수 + 1
		mapper.updateReadCnt(Integer.parseInt(boardNo)); //count가 목록 보여주고 나서 카운트됨.
		//table 출력
		PrintWriter out = resp.getWriter();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = "";
		str += "<table border = '1'>";
		str += "<tbody>";
		str += "<tr><th>글번호</th><td>" + board.getBoardNo();
		str +="</td><th>조회수</th><td>" + board.getReadCnt() + "</td></tr>";
		str += "<tr><th>제목</th><td colspan='3'>" + board.getTitle() +"</td></tr>";
		str += "<tr><th>내용</th><td colspan='3'>" + board.getContent() + "</td></tr>";
		str += "<tr><th>작성자</th><td colspan='3'>" + board.getWriter() + "</td></tr>";
		str += "<tr><th>작성일시</th><td colspan='3'>" + sdf.format(board.getWriteDate()) +"</td></tr>";
		str += "</tbody></table>";
		str += "<p><a href='servlet/boardList.serv'>목록 이동</a></p>";
		out.print(str);
		
		
	}
}
