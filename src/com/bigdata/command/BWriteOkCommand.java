package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BWriteOkCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");
		
		// 글 하나 생성
		BoardDto board = new BoardDto(name, email, homepage, title, content, pw);

		BoardDao boardDao = BoardDao.getInstance();
		int ri = boardDao.write(board);
		
		//request
		request.setAttribute("board", board);
		request.setAttribute("ri", ri);
		
		
	}
}
