<%@page import="memberInfo.BoardDao"%>
<%@page import="memberInfo.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	




<form action="/bigdata/finalmvcboard/board/updateOk.do" method="post" name="update_form">
	<input type="hidden" name="idx" value="${idx}">
    <fieldset class="u_fieldset">
        <table class="u_table">
            <tr>
                <th>작성자</th>
                <th><input type="text" style="width: 80px;" class="m_writer" value="${name}" name="name"></th>
            </tr>
            <tr>
                <th>비밀번호</th>
                <th><input type="password" style="width: 80px;" class="m_pwd" name="pw"></th>
            </tr>
            <tr>
                <th>E-Mail</th>
                <th><input type="email" style="width: 200px;" value="${email}" name="email"></th>
            </tr>
            <tr>
                <th>홈페이지</th>
                <th><input type="text" style="width: 200px;" value="${homepage}" name="homepage"></th>
            </tr>
            
            <tr>
                <th>제 목</th>
                <th><input type="text" style="width: 450px;" class="m_title" value="${title}" name="title"></th>
            </tr>
            <tr>
                <th>파일첨부</th>
                <th><input type="file" style="width: 200px" name=""></th>
            </tr>
            <tr>
                <th>내 용</th>
                <th><textarea cols="100" rows="15" class="m_txt" name="content">${content}</textarea></th>
            </tr>
        </table>
        <div style="text-align: center;">
            <button type="button" class="b_modify" onclick="b_modify_click();">수정 완료</button>
            <button type="reset" class="b_update">다시 수정</button>
            <button type="button" class="b_back_list" onclick="b_back_list_click();" >뒤로</button>
        </div>        
    </fieldset>
</form>    