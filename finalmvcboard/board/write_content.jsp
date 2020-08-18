<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form action="/bigdata/board/writeOk.jsp" method="post">
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
                <th><input type="text" style="width: 450px;" class="title" required name="title"></th>
            </tr>
            <tr>
                <th>파일첨부</th>
                <th><input type="file" style="width: 200px" name="bfile" id="bfile"></th>
            </tr>
            <tr>
                <th>내 용</th>
                <th><textarea cols="100" rows="15" class="txt" required name="content"></textarea></th>
            </tr>
        </table>
        <div style="text-align: center;">
            <input type="submit" value="등록" class="b_apply">
            <input type="button" value="뒤로" class="b_back" onclick="history.back();">
        </div>
        <br>
    </fieldset>
</form>