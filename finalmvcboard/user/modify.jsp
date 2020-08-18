<%@page import="memberInfo.memberInfoDto"%>
<%@page import="memberInfo.memberInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify.jsp</title>
<link rel="stylesheet" href="/bigdata/css/common.css">
<link rel="stylesheet" href="/bigdata/css/login.css">
</head>

<body>

	<div class="wrapper">
		<!-- header -->
		<%@ include file="/finalmvcboard/layout/header.jsp"%>
		<% if(session.getAttribute("id") == null) { %>
			<jsp:forward page="/mvcboard/login.do" />
		<% } %>
		<!-- content -->
		<%@ include file="/finalmvcboard/user/modify_content.jsp"%>

		<!-- footer -->
		<%@ include file="/layout/footer.jsp"%>

    </div>

</body>
</html>