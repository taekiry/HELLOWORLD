<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${10-5 eq 10 }
	<%
	//생존 주기 짧은거부터 길게
	request.setAttribute("msg", "Hello World");
	session.setAttribute("errorMsg", "ID와 PW를 확인하세요");
	application.setAttribute("projectName", "BoardWeb");
	
	
	BoardService svc = new BoardServiceImpl();
	SearchDTO search = new SearchDTO();
	search.setPage(1);
	List<BoardVO> list = svc.boardList(search);
	request.setAttribute("blist", list);
	%>
	<p>${!empty msg}</p>
	<p>${errorMsg}</p>
	<p>${empty hello }</p>

	<!-- 변수선언  String name = "hongkildong";  -->
	<c:set var="name" value="Hongkildong"></c:set>
	<c:out value="${name }"></c:out>

	<c:set var="age" value="15"></c:set>
	<c:if test="${age >= 20 }">
		<p>성인</p>
	</c:if>
<!-- <c:if test="${!empty logId }">
		<p>로그아웃 상태</p>
	</c:if> 주석처리할때 주의 $중괄호 는 실행되버림. -->	
	<c:choose>
		<c:when test="${!empty logId }">
			<p>로그인 상태</p>
		</c:when>
		<c:otherwise>
			<p>로그아웃 상태</p>
		</c:otherwise>
	</c:choose>

	<!-- 반복문1 증감식은 step-->
	<c:forEach var="i" begin="1" end="5" step="1">
		<span>i의 값은 ${i }입니다.</span>
	</c:forEach>

	<!-- 반복문2 collection list의 attribute값 담을 때 items-->
	<table border="1">
		<c:forEach var="board" items="${blist }">
		<tr>
			<td>${board.boardNo }</td> 	<!--  board.getBoardNo()의 역할 -->
			<td>${board.title }</td>
			<td><c:out value="${board.writer }" /></td>
			<td><fmt:formatDate value="${board.writeDate }" pattern="YYYY-MM-dd HH:mm:ss" /></td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>