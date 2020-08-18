<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<form action="/bigdata/finalmvcboard/user/joinOk.do" method="post" name="join_form">
	<fieldset class="title">
		<h3>회원가입</h3>
	</fieldset>
	<br>
	<fieldset class="usertyping">
		<p>사이트 이용정보 입력</p>
		<input type="text" class="id" placeholder="아이디" name="id"><br>
		<p class="text">영문자, 숫자, _만 입력 가능, 최소 3자 이상 입력하세요.</p>
		
		<input type="password" placeholder="비밀번호" class="pw" name="pw"><br>
		
		<input type="password" placeholder="비밀번호확인" class="rpwd" name="rpwd"><br>
		
		<p>개인정보 입력</p>
		<input type="text" placeholder="이름" class="name" name="name"><br>
		
		<input type="text" placeholder="닉네임" class="n_name" name="n_name"><br>
		<p class="text">공백없이 한글,영문,숫자만 입력 가능(한글2자, 영문4자 이상</p>
		<p class="text">닉네임을 바꾸시려면 앞으로 60일 이내에는 변경 할 수 없습니다.</p>
		
		<input type="email" placeholder="E-mail" class="email" name="email"><br><br>
		<div id="btn_group">
			<button type="button" id="test_btn1" class="b_join"
				onclick="b_join_click();">회원가입</button>
			<button type="button" id="test_btn2" class="b_cancle"
				onclick="b_cancle_click();">취소</button>
		</div>
	</fieldset>
</form>