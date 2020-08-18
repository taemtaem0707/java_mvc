<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/bigdata/css/common.css">
<link rel="stylesheet" href="/bigdata/css/login.css">
<title>로그인</title>
</head>

<body>
	<div class="wrapper">
		<!-- header -->
		<%@ include file="/finalmvcboard/layout/header.jsp"%>

		<!-- content -->
		<%@ include file="/finalmvcboard/user/login_content.jsp"%>

		<!-- footer -->
		<%@ include file="/layout/footer.jsp"%>
	</div>

	<script src="/bigdata/js/login.js"></script>

</body>
</html>