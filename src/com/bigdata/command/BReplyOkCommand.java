package com.bigdata.command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BReplyOkCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//넘어온 데이터 받기 => dao로 보내기(위의 jsp 과정과 같은 것)
		String sidx = request.getParameter("idx");
		int idx = Integer.parseInt(sidx);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String pw = request.getParameter("pw");
		String sgroup = request.getParameter("group");
		int group = Integer.parseInt(sgroup);
		String sstep = request.getParameter("step");
		int step = Integer.parseInt(sstep);
		String sindent = request.getParameter("indent");
		int indent = Integer.parseInt(sindent);
		
		// 글 하나 생성
		BoardDto boardDto = new BoardDto(name, email, homepage, title, content, pw, group, step, indent);

		BoardDao boardDao = BoardDao.getInstance();
		
		int ri = boardDao.reply(boardDto);
		
		request.setAttribute("ri", ri);
		request.setAttribute("idx", idx);
	}
}
