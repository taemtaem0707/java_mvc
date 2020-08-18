<%@page import="memberInfo.memberInfoDao"%>
<%@page import="memberInfo.memberInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String email = (String)session.getAttribute("email"); %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/bigdata/css/common.css">
<link rel="stylesheet" href="/bigdata/css/login.css">
</head>

<body>
    <div class="wrapper">
		<!-- header -->
		<%@ include file="/finalmvcboard/layout/header.jsp"%>
		
		<!-- userinfo_content -->
		<%@ include file="/finalmvcboard/user/userinfo_content.jsp"%>

		<!-- footer -->
		<%@ include file="/layout/footer.jsp"%>

    </div>

	<script src="/bigdata/js/board.js"></script>
    

</body>
</html>