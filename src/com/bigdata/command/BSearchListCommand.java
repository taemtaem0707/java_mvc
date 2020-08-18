package com.bigdata.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BSearchListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String option = request.getParameter("keyWord");
		String word = request.getParameter("searchWord");

		//페이지 번호
		int pageNum = 0;
		if(request.getParameter("page") == null) {
			pageNum = 1;
		}else {
			pageNum = Integer.parseInt(request.getParameter("page"));
		}
		BoardDao boardDao = BoardDao.getInstance();

		//한페이지 리스트 카운트
		int pageList = 5;

		//전체 리스트 카운트
		int count = boardDao.getSearchCount(option, word);

		//page 개수 카운트 (ceil = 올림함수)
		int pageCount = (int)Math.ceil((double)count / pageList);

		//글 목록 가져오기 + 
		ArrayList<BoardDto> boards = null;
		if(option.equals("name")) {
			boards = boardDao.getBoardNameAll(word, pageNum, pageList);
		}else if(option.equals("title")) {
				boards = boardDao.getBoardTitleAll(word, pageNum, pageList);
		}else if(option.equals("content")) {
				boards = boardDao.getBoardContentAll(word, pageNum, pageList);
		}
		
		
		request.setAttribute("boards", boards);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("option", option);
		request.setAttribute("word", word);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("count", count);
	}
}
