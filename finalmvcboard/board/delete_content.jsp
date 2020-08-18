<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="/bigdata/finalmvcboard/board/deleteOk.do" method="post">
	<input type="hidden" name="idx" value="${idx}">
	<fieldset class="d_fieldset">
		<p>작성자의 비밀번호를 입력해 주세요.</p>
		<input type="password" class="b_pwd" name="pw"> <br>
		<br>
		<input type="submit" value="삭제완료" class="b_delete">&nbsp;
		<input type="button" value="뒤로" class="b_d_back" onclick="b_d_back_click();">
	</fieldset>
</form>