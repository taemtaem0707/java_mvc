<%@page import="memberInfo.BoardDto"%>
<%@page import="memberInfo.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//답변할 글 번호 받기
	String sIdx = request.getParameter("idx");
	int idx = Integer.parseInt(sIdx);
	BoardDao boardDao = BoardDao.getInstance();

	//이전 글 내용 가져오기
	BoardDto boardDto = boardDao.getBoardOne(idx);
	String title = "Re >>" + boardDto.getTitle();
	String content = boardDto.getContent();
	int group = boardDto.getGroup();
	int step = boardDto.getStep();
	int indent = boardDto.getIndent();
	
%>	

<form action="/bigdata/finalmvcboard/board/replyOk.do" method="post">
	<input type="hidden" name="idx" value=<%=idx %>>
	<input type="hidden" name="group" value=<%=group %>>
	<input type="hidden" name="step" value=<%=step %>>
	<input type="hidden" name="indent" value=<%=indent %>>
    <fieldset class="w_fieldset">
        <table class="w_table">
            <tr>
                <th>작성자</th>
                <th><input type="text" style="width: 80px;"  class="writer" required  name="name"></th>
            </tr>
            <tr>
                <th>비밀번호</th>
                <th><input type="password" style="width: 80px;" class="pwd" required name="pw"></th>
            </tr>
            <tr>
                <th>E-Mail</th>
                <th><input type="email" style="width: 200px;" id="e-mail" name="email"></th>
            </tr>
            <tr>
                <th>홈페이지</th>
                <th><input type="text" style="width: 200px;" name="homepage"></th>
            </tr>
            <tr>
                <th>제 목</th>
                <th><input type="text" style="width: 450px;" class="title" required name="title" value="&nbsp;<%=title %>" readonly="readonly"></th>
            </tr>
            <tr>
                <th>파일첨부</th>
                <th><input type="file" style="width: 200px"></th>
            </tr>
            <tr>
                <th>내 용</th>
                <th><input type="text" style="width: 700px; height: 230px;" class="txt" required name="content" value="" ></th>
            </tr>
        </table>
        <div style="text-align: center;">
            <input type="submit" value="등록" class="b_apply">
            <input type="button" value="뒤로" class="b_back" onclick="history.back();">
        </div>
        <br>
    </fieldset>
</form>