<%@page import="memberInfo.BoardDto"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	
	<c:choose>
		<c:when test="${ri == 1}">
			<script>
				alert('삭제 성공');
				location.href="/bigdata/finalmvcboard/board/list.do";
			</script>	
		</c:when>
			
		<c:when test="${ri == 0}">
			<script>
			alert('비밀번호가 틀립니다.');
			history.back();
			</script>
		</c:when>
				
		<c:otherwise>
			<script>
			alert('삭제 실패');
			history.back();
			</script>	
		</c:otherwise>
	</c:choose>
