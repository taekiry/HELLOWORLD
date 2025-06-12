<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Sidebar-->
<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">Start
		Bootstrap</div>
	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
		href="boardList.do">게시글 목록</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
	    href="addBoard.do">글 등록화면</a>
		<c:choose>
			<c:when test="${empty logId }">
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="loginForm.do">로그인 화면</a>
			</c:when>
			<c:otherwise>
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="loginForm.do">로그아웃(${logId })</a>
			</c:otherwise>
		</c:choose>
		<a class="list-group-item list-group-item-action list-group-item-light
		p-3" href="allProduct.do">자바스크립트 연습</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
		href="#!">Profile</a> 
		<a class="list-group-item list-group-item-action list-group-item-light p-3"
	    href="#!">Status</a>
	</div>
</div>