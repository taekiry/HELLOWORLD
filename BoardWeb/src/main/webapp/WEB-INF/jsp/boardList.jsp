<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
   <jsp:include page="../include/header.jsp" /> <!-- 코드 너무길어질까바 header, footer 따로 빼둠 -->
    <%
    	List<BoardVO> list = (List <BoardVO>) request.getAttribute("blist"); //getAttribute -> object타입 반환 
    %>
        <h3>게시글 목록</h3>
        <table class ="table">
           <thead>
            <tr>
                <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
            </tr>
           </thead>
           <tbody>
           <% for ( BoardVO board : list ){ %>
            <tr>
                <td><a href="board.do?bno=<%=board.getBoardNo() %>"><%=board.getBoardNo() %></a></td>
                <td><%=board.getTitle() %></td><td><%=board.getWriter() %></td>
                <td><%=board.getWriteDate() %></td><td><%=board.getReadCnt() %></td>
            </tr>
           <% } %> 
           </tbody>
        </table>
   <jsp:include page="../include/footer.jsp" />     
      