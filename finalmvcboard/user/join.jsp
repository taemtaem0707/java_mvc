<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/bigdata/css/common.css">
<link rel="stylesheet" href="/bigdata/css/join.css">
<title>회원가입</title>
</head>

<body>
	<div class="wrapper">
		<!-- header -->
		<%@ include file="/finalmvcboard/layout/header.jsp"%>

		<!-- content -->
		<%@ include file="/finalmvcboard/user/join_content.jsp"%>

		<!-- footer -->
		<%@ include file="/layout/footer.jsp"%>
	</div>

	<script src="/bigdata/js/join.js"></script>

</body>
</html>