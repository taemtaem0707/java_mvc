package com.bigdata.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BUpdateOkCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
		String sidx = request.getParameter("idx");
		int idx = Integer.parseInt(sidx);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");

		BoardDao boardDao = BoardDao.getInstance();
		BoardDto boardDto = null;

		//비밀번호 체크
		boardDto = boardDao.getBoardOne(idx);
		System.out.println(pw);
		System.out.println(boardDto.getPw());
		int ri = -1;
		if(pw.equals(boardDto.getPw())) {
			//글 하나 생성
			boardDto = new BoardDto(name, email, homepage, title, content, pw);
			//update 실행 
			
			ri = boardDao.update(boardDto, idx);
		}else if(!pw.equals(boardDto.getPw())){
			ri = 0;
		}
		System.out.println(ri);
		
			
		request.setAttribute("ri", ri);
		request.setAttribute("idx", idx);

		
	}
}
