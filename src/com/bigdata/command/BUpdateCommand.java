package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BUpdateCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		//수정할 글 번호 받기
		String sidx = request.getParameter("idx");
		System.out.println("sidx :" + sidx);
		int idx = Integer.parseInt(sidx);
		System.out.println("idx :" + idx);
		BoardDao boardDao = BoardDao.getInstance();

		//이전 글 내용 가져오기
		BoardDto boardDto = boardDao.getBoardOne(idx);
		
		String name = boardDto.getName();
		String email = boardDto.getEmail();
		String homepage = boardDto.getHomepage();
		String title = boardDto.getTitle();
		String content = boardDto.getContent();
		
		//request
		request.setAttribute("idx", idx);
		request.setAttribute("boardDto", boardDto);
		request.setAttribute("email", email);
		request.setAttribute("name", name);
		request.setAttribute("homepage", homepage);
		request.setAttribute("title", title);
		request.setAttribute("content", content);

	}
}
