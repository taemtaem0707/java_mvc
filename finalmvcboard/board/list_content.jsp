<%@page import="com.sun.glass.ui.View"%>
<%@page import="memberInfo.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

		
	
<table align="center" width="800px" height="40px">
	<tr class="index0_title">
		<th>게시판</th>
	</tr>
</table>

<br>

<table align="center" width="800px" height="300px">
	<tr class="index0_title">
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회</th>
	</tr>
	<c:choose>
		<c:when test="${boards ne null}">
		<c:forEach items="${boards}" var="board">
			<tr>
				<th>${board.idx}</th>
				<th class="title">
				<c:forEach begin="1" end="${board.indent*3}">&nbsp;</c:forEach>
				<a href="/bigdata/finalmvcboard/board/view.do?idx=${board.idx}">${board.title}</a></th>
				<th>${board.name}</th>
				<th>${board.regdate}</th>
				<th>${board.hit}</th>
			</tr>
		</c:forEach>
		</c:when>
		<c:otherwise>
				<tr><td colspan='6'>작성된 글이 없습니다.</td></tr>
		</c:otherwise>
	</c:choose>
	<tr>
		<th colspan="5">
		<a href="#" onclick="page_click();"><</a>
			<c:forEach var="i" begin="1" end="${pageCount}">
				<c:choose>
					<c:when test="${i == pageNum}">[${i}]</c:when>
					<c:when test="${i != pageNum}"><a href="/bigdata/finalmvcboard/board/list.do?page=${i}">[${i}]</a></c:when>
				</c:choose>
			</c:forEach>
			
		<a href="#" onclick="page_click();">></a>
			<div style="text-align: center;">
				<button type="button" class="b_write" onclick="b_write_click();">글쓰기</button>
					Total : ${count}
					page : ${pageNum}/${pageCount}
			</div>
		</th>
	</tr>
</table>