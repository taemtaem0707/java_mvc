<%@page import="memberInfo.memberInfoDao"%>
<%@page import="memberInfo.memberInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<c:choose>
	<c:when test="${id == null}">
		<header>
			<a class="logo" href="/bigdata/finalmvcboard/main/main.do">
				<img src="/bigdata/img/logo2.png" alt="logo">
			</a>
			<nav>
				<li><a href="/bigdata/finalmvcboard/user/login.do">Login</a></li>
				<li>|</li>
				<li><a href="/bigdata/finalmvcboard/user/join.do">회원가입</a></li>
			</nav>
		</header>
		<br><hr>
		<div class="header_div">&nbsp</div>
		<hr><br><br>
	</c:when>
	
	<c:otherwise>
		<header>
			<a class="logo" href="/bigdata/finalmvcboard/main/main.do">
				<img src="/bigdata/img/logo2.png" alt="logo">
			</a>
			<nav>
				<li><li class="user_name"></li> ${id}님 환영합니다.&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</li>
        		<li>|</li>
        		<li><a href="/bigdata/finalmvcboard/user/logout.do">로그아웃</a></li>
        		<li>|</li>
        		<li><a href="/bigdata/finalmvcboard/board/list.do">게시판</a></li>
				<li>|</li>
        		<li><a href="/bigdata/finalmvcboard/user/userinfo.do?id=${id}">회원정보</a></li>
        	</nav>
		</header>
		<br><hr>
		<div class="header_div">&nbsp</div>
		<hr><br><br>
	</c:otherwise>	
</c:choose>
