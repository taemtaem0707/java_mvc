package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BReplyCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
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
		
		request.setAttribute("idx", idx);
		request.setAttribute("group", group);
		request.setAttribute("step", step);
		request.setAttribute("indent", indent);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
	}
}
