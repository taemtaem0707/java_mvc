<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<c:remove var="id" scope="session"/>
<script>
	alert("안녕히가세요!");
	location.href='/bigdata/finalmvcboard/main/main.do';
</script>