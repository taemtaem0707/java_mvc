<%@page import="memberInfo.memberInfoDao"%>
<%@page import="memberInfo.memberInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%
	String pw = request.getParameter("pw");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String n_name = request.getParameter("n_name");
	String email = request.getParameter("email");
%>

	<fieldset class="f_h3"><h3>정보수정</h3></fieldset><br>
	<form action="/bigdata/finalmvcboard/user/modifyOk.do?id=${id}" method="post" name="reg_frm">
		<fieldset class="f_modify">
		<table>
			<tr><th>아이디</th><td><input value="${id}" readonly="readonly" ></td></tr>
			<tr><th>비밀번호</th><td><input value="${pw}" type="password" name="pw" size="20"></td></tr>
			<tr><th>비밀번호확인</th><td><input value="${pw}" type="password" name="pw" size="20"></td></tr>
			<tr><th>이름</th><td><input value="${name}" type="text" name="name" size="20"></td></tr>
			<tr><th>닉네임</th><td><input value="${n_name}" type="text" name="n_name" size="20"></td></tr>
			<tr><th>메일</th><td><input value="${email}" type="text" name="email" size="20"></td></tr>
		</table>
		
	
			<div style="text-align: center;">
			<input type="submit" value="수정" class="b_login">&nbsp;&nbsp;&nbsp; 
			<input type="reset" value="취소" onclick="javascript:window.location='/bigdata/finalmvcboard/user/userinfo.do?id=${id}'" class="b_back">
			</div>
		</fieldset>
	</form>

    
	

		
		
		
