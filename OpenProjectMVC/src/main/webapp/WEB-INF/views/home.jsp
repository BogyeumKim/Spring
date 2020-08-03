<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>INDEX</title>
	<%-- 
<link rel="stylesheet" href="<c:url value="/css/default.css"/>"> --%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
	
</head>
<body>

		<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	
	
	어서오세요 인덱스 홈페이지입니다.
	
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
	

</body>
</html>
