<%@page import="memberInfo.memberInfoDto"%>
<%@page import="memberInfo.memberInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<% request.setCharacterEncoding("UTF-8"); %>


<c:choose>
	<c:when test="${ri == 1}">
		<script>
		alert('정보 변경 성공');
		location.href='/bigdata/finalmvcboard/user/modify.do?id=${id}';
		</script>	
	</c:when>
	<c:when test="${ri == 5}">
		<script>
		alert('비밀번호 오류');
		history.back();
		</script>	
	</c:when>
	<c:otherwise>
		<script>
		alert('정보 변경 실패');
		history.back();
		</script>
	</c:otherwise>	
</c:choose>
