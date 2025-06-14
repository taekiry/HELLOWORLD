<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp" />
<% BoardVO board = (BoardVO) request.getAttribute("board"); %>
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyBoard.do">
    <input type="hidden" name="bno" value="<%=board.getBoardNo() %>">
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
                    <input type="submit" value="수정" class="btn btn-warning">
                    <button class="btn btn-danger">삭제</button>
                </td>
            </tr>
    </table>
    </form>
    <jsp:include page="../include/footer.jsp" />