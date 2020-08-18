<%@page import="memberInfo.memberInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<c:choose>
	<c:when test="${ri == -1}">
		<script>
		alert('회원정보가 없습니다.');
		history.back();
		</script>	
	</c:when>
	
	<c:when test="${ri == 0}">
		<script>
		alert('비번이 틀렸어요.');
		history.back();
		</script>
	</c:when>
	
	<c:otherwise>
	<c:set var="id" value="${id}" scope="session" />
		<script>
		alert('환영합니다.');
		location.href="/bigdata/finalmvcboard/main/main.do"
		</script>
	</c:otherwise>	
</c:choose>



