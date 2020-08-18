<%@page import="memberInfo.BoardDto"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	



	<c:choose>
		<c:when test="${ri == 1}">
			<script>
				alert('글 답변이 등록되었습니다.');
				location.href='/bigdata/finalmvcboard/board/list.do';
			</script>		
		</c:when>
	
		<c:otherwise>
			<script>
				alert('오류 발생');
				history.back();
			</script>
		</c:otherwise>
	</c:choose>

	

