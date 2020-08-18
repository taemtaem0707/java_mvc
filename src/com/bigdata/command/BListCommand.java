package com.bigdata.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BListCommand implements BCommand{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 페이지 번호
		int pageNum = 0;
		if(request.getParameter("page") == null) {
			pageNum = 1;
		}else {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		
		//한페이지 리스트 카운트
		int pageList = 5;
		
		//글 목록 전체 가져오기
		BoardDao boardDao = BoardDao.getInstance();
		ArrayList<BoardDto> boards = boardDao.getBoardAll(pageNum, pageList);		

		//전체 리스트 카운트
		int count = boardDao.getCount();

		// page 개수 카운트 (ceil = 올림함수)
		int pageCount = (int)Math.ceil((double)count / pageList);
		
		//request
		request.setAttribute("boards", boards);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", pageNum);
		
	}
}
