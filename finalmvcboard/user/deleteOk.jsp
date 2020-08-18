<%@page import="memberInfo.memberInfoDao"%>
<%@page import="memberInfo.memberInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<% if(session.getAttribute("id") == null) { 
	response.sendRedirect("/bigdata/login/login.jsp");
 } %>
 


<c:choose>
		<c:when test="${ri == 0}">
			<script>
				alert('비밀번호 오류.');
				history.back();
			</script>	
		</c:when>
		<c:when test="${ri == 1}">
			<script>
				alert('탈퇴 완료');
				<%session.invalidate();%>
				location.href='/bigdata/finalmvcboard/main/main.do';
			</script>
		</c:when>	
</c:choose>
