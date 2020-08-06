<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
	<h1 id="header">Open Project</h1>
	<ul id="nav">
		
		<li><a href="${pageContext.request.contextPath}/member/memberReg">회원가입</a></li>
		
		<li><a href="<c:url value="/login/login"/>">로그인</a></li>
		
		<li><a href="<c:url value="/member/list"/>">회원목록</a></li>
		<li>방명록(비회원)</li>
		<li>방명록(회원제)</li>
	</ul>
	
	
	
	
	
	
	