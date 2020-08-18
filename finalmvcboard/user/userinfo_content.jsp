<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	
<c:choose>
	<c:when test="${id == null }">
		<script>
		history.back();
		</script>	
	</c:when>
</c:choose>

<form action="" name="" method="POST">
	<fieldset class="f_h3"><h3>회원정보</h3></fieldset>
	<br>
	<fieldset class="f_user">
		<table  align="center" width="300px" height="140px">
			<tr><th>아이디</th><td>${id}</td></tr>
			<tr><th>이름</th><td>${name}</td></tr>
			<tr><th>닉네임</th><td>${n_name}</td></tr>
			<tr><th>이메일</th><td>${email}</td></tr>
		</table>
		<br>
		<div style="text-align: center;">
			<button type="button" onclick="location.href='/bigdata/finalmvcboard/user/modify.do?id=${id}'" class="b_back">정보수정</button>
			<button type="button" onclick = "location.href='/bigdata/finalmvcboard/user/delete.do?id=${id}'" class="b_login">회원삭제</button>
		</div>
	</fieldset>		
</form>
		