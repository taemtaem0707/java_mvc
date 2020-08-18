<%@page import="memberInfo.BoardDto"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="aa" class="memberInfo.BoardDto" />
<jsp:setProperty property="*" name="aa"/>

<%
	
	//넘어온 데이터 받기 => dao로 보내기(위의 jsp 과정과 같은 것)
	/* String name = request.getParameter("bname");
	String email = request.getParameter("bemail");
	String homepage = request.getParameter("homepage");
	String title = request.getParameter("btitle");
	String content = request.getParameter("bcontent");
	String pw = request.getParameter("pw");
	
	BoardDto board = new BoardDto(name, email, homepage, title, content, pw); */

	BoardDao boardDao = BoardDao.getInstance();
	int ri = boardDao.write(aa);
%>


<%if(ri == 1) { %>
<Script>
alert('글이 등록되었습니다.');
location.href='/bigdata/list.jsp';
</Script>
<% }else { %>
<Script>
alert('오류 발생');
history.back();
</Script>
<% } %>