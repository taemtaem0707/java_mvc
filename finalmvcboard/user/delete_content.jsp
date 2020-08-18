<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<fieldset class="f_h3">
		<h3>회원탈퇴</h3>
	</fieldset><br>
<form action="/bigdata/finalmvcboard/user/deleteOk.do" method="post">
	<input type="hidden" name="id" value="${id}">
	<fieldset class="f_delete">비밀번호 입력<br>
	<input type="text" name="pw">
	<br>
	<input type="submit" value="전송" class="b_login">
	<input type="button" value="취소" onclick="history.back();" class="b_back">
	</fieldset>	
</form>