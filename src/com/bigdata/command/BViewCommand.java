package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String sdx = request.getParameter("idx");
		int idx = Integer.parseInt(sdx);	
		BoardDao boardDao = BoardDao.getInstance();
		//조회수 증가
		boardDao.setBoardHit(idx);

		//글 한개 가져오기
		BoardDto board = boardDao.getBoardOne(idx);
		
		String name = board.getName();
		String regdate = board.getRegdate();
		String email = board.getEmail();
		String homepage = board.getHomepage();
		String title = board.getTitle();
		String content = board.getContent();
		int hit = board.getHit();
		
		
		//request
		request.setAttribute("name", name);
		request.setAttribute("regdate", regdate);
		request.setAttribute("email", email);
		request.setAttribute("homepage", homepage);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		request.setAttribute("hit", hit);
		request.setAttribute("idx", idx);
		
		
		
	}
}
