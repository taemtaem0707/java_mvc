package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BDeleteOkCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String sIdx = request.getParameter("idx");
		int idx = Integer.parseInt(sIdx);
		String pw = request.getParameter("pw");
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = boardDao.getBoardOne(idx);
		
		int ri = 0;
		if(pw.equals(boardDto.getPw())) { 
			ri = boardDao.delete(idx);
			System.out.println(ri);
		}else if(!pw.equals(boardDto.getPw())) {
		 ri = 0;
		};
		
		
		
		
		
		
		request.setAttribute("idx", idx);
		request.setAttribute("pw", pw);
		request.setAttribute("ri", ri);
	}
}
