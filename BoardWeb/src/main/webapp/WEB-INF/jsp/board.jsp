<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<% BoardVO board = (BoardVO) request.getAttribute("board");
	String sc = (String) request.getAttribute("searchCondition");
	String kw = (String) request.getAttribute("keyword");
	String pg = (String) request.getAttribute("page");
	String logId = (String) session.getAttribute("logId");
%>
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyForm.do">
    <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
    <input type="hidden" name="searchCondition" value="<%=sc %>">
    <input type="hidden" name="keyword" value="<%=kw %>">
    <input type="hidden" name="page" value="<%=pg %>">
    	
    <table class="table"><!--table.table-->
            <tr>
                <th>글번호</th><td><%=board.getBoardNo() %></td>
                <th>조회수</th><td><%=board.getReadCnt() %></td>
            </tr>
            <tr>
                <th>제목</th><td colspan="3"><%=board.getTitle() %></td>
            </tr>
            <tr>
                <th>내용</th><td colspan="3"><textarea cols="40" rows="4" readonly><%=board.getContent() %></textarea></td>
            </tr>
            <tr>
                <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
            </tr>
            <tr>
                <th>작성일시</th><td colspan="3"><%=board.getWriteDate() %></td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                <%if(logId.equals(board.getWriter())) {%>
                    <input type="submit" value="수정" class="btn btn-warning">
                    <button class="btn btn-danger" type="button">삭제</button>
                <%} else {%>
                	<input  disabled type="submit" value="수정" class="btn btn-warning">
                    <button disabled class="btn btn-danger" type="button">삭제</button>
                <% }%>    
                </td>
            </tr>
    </table>
	</form>
    <script>
    let bno = "<%=board.getBoardNo() %>";
    console.log(bno);
    document.querySelector('button.btn-danger').addEventListener('click',function(){
		location.href = 'removeBoard.do?bno='+bno;
    })
    </script>
    <jsp:include page="../include/footer.jsp" />