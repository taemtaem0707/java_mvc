<%@page import="memberInfo.BoardDto"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/bigdata/board/viewOk.jsp" method="post">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<fieldset class="l_fieldset">
	<h3>글 읽기</h3>
	<table class="l_table">
		<tr class="l_tr">
			<th>작성자</th>
			<td align="left">${name}</td>
			<th>작성일</th>
			<td align="left">${regdate}</td>
		</tr>
		<tr class="l_tr">
			<th>E-Mail</th>
			<td align="left">${email}</td>
			<th>홈페이지</th>
			
			<c:choose>
				<c:when test="${homepage}.length() == 0">
				<td></td>
				</c:when>
				<c:otherwise>
				<td align="left"><a hreg="${homepage}" target="_blacnk">${homepage}</a></td>
				</c:otherwise>
			</c:choose>
			
		</tr>
		<tr class="l_tr">
			<th>파일첨부</th>
			<td colspan="3" align="left"><a class="btn"
				href="/bigdata/스토리보드.txt" download>스토리보드.txt(2kb)</a></td>
		</tr>
		<tr class="l_tr">
			<th>제목</th>
			<td colspan="3" align="left">${title}</td>
		</tr>
		<tr>
			<td colspan="4" align="left">${content}</td>
		</tr>
		<tr>
			<td colspan="4" align="right">조회수 : ${hit}</td>
		</tr>
	</table>
	<div style="text-align: center;">
		<button type="button" class="b_index0" onclick="b_list_click();">목록</button>
		<button type="button" class="b_update" onclick="location.href='/bigdata/finalmvcboard/board/update.do?idx=${idx}';">수정</button>
		<button type="button" class="b_reply" onclick="location.href='/bigdata/finalmvcboard/board/reply.do?idx=${idx}';">답변</button>
		<button type="button" class="b_delete" onclick="location.href='/bigdata/finalmvcboard/board/delete.do?idx=${idx}';">삭제</button>
		
	</div>
	<br>
