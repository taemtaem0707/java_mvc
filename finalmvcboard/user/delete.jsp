<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("id") == null) { 
	response.sendRedirect("/bigdata/login/login.jsp");
 } %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/bigdata/css/common.css">
<link rel="stylesheet" href="/bigdata/css/login.css">
<title>Insert title here</title>
</head>

<body>
<%
	//String id = (String)session.getAttribute("id");
%>
	<div class="wrapper">
		<!-- header -->
		<%@ include file="/finalmvcboard/layout/header.jsp"%>
		
		<!-- content -->
		<%@ include file="/finalmvcboard/user/delete_content.jsp"%>

		<!-- footer -->
		<%@ include file="/layout/footer.jsp"%>

    </div>

	<script src="/bigdata/js/board.js"></script>

</body>

</html>