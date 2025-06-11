<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String logId = (String) session.getAttribute("logId");
%>
	<h3>글등록 화면</h3>
    <form action="addBoard.do" method="post">
    <input type="hidden" class="form-control" value="<%=logId %>" name="writer">
	 <table class="table">
	   <tr>
	     <th>제목</th><td><input type="text" required name="title"></td></tr>
	   <tr>
	     <th>내용</th><td><input type="text" required name="content"></td></tr>
	   <tr>
	     <th>작성자</th><td><%=logId %></td></tr>
	   <tr>
	     <td colspan="2" align="center">
	       <input type="submit" value="등록" class="btn btn-primary">
	      <button type="reset" class="btn btn-danger">취소</button></td>
	     </tr>
	 </table>
	</form>
	