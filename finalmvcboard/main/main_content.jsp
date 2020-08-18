<%@page import="java.util.ArrayList"%>
<%@page import="memberInfo.memberInfoDao"%>
<%@page import="memberInfo.memberInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	


<table  align="center" width="800px" height="300px">
	<tr class="index0_title">
		<th>id</th>
		<th>pw</th>
		<th>name</th>
		<th>n_name</th>
		<th>email</th>
		<th>regdate</th>
	</tr>
	<c:forEach items="${memberList}" var="member">
	<tr>
		<th>${member.id}</th>
		<th>${member.pw}</th>
		<th>${member.name}</th>
		<th>${member.n_name}</th>
		<th>${member.email}</th>
		<th>${member.regdate}</th>
		
	</tr>
	</c:forEach>
	
</table>

