<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form id="login_form" action="/bigdata/finalmvcboard/user/loginOk.do" name="form" method="POST">
	<fieldset class="f_h3">
		<h3>로그인</h3>
	</fieldset>
	<br>
	<fieldset class="f_login">
		<input type="text" class="id" name="id" placeholder="아이디(필수)"><br>
		<input type="password" class="pw" name="pw" placeholder="비밀번호(필수)"><br>
		<br>
		<div style="text-align: center;">
			<button type="submit" class="b_login" onclick="b_login_click();">로그인</button>
			<button type="button" class="b_back" onclick="b_back_click();">뒤로</button>
		</div>
		<div style="text-align: center;">
			<button type="button" class="b_join" onclick="b_join_click();">회원가입</button>
		</div>
	</fieldset>
</form>