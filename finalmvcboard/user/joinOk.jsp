<%@page import="memberInfo.memberInfoDto"%>
<%@page import="memberInfo.memberInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	


	<c:choose>
		<c:when test="${ri == 1}">
			<script>
			alert('아이디가 이미 존재합니다.')
			history.back();
			</script>		
		</c:when>
	
		<c:otherwise>
			<c:choose>
				<c:when test="${ri2 == 1}">
					<script>
					alert('회원가입 성공')
					location.href="/bigdata/finalmvcboard/user/login.do";
					</script>	
				</c:when>
			
				<c:otherwise>
					<script>
						<script>
						alert('회원가입 실패 - 잠시 후 다시 시도해 주세요.')
						history.back();
					</script>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>