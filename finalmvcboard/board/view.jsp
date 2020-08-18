<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/bigdata/css/common.css">
    <link rel="stylesheet" href="/bigdata/css/board.css">
    <title>게시글</title>
</head>

<body>
    <div class="wrapper">
    	<!-- header -->
   		<%@ include file = "/finalmvcboard/layout/header.jsp" %>
        
    	<!-- content -->
    	<%@ include file = "/finalmvcboard/board/view_content.jsp" %>
    
    	<!-- footer -->
    	<%@ include file = "/layout/footer.jsp" %>
	</div>

    <script src="/bigdata/js/board.js"></script>

</body>
</html>