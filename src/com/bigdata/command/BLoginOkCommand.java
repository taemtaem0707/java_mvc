package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;
import memberInfo.memberInfoDao;

public class BLoginOkCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String n_name = request.getParameter("n_name");
		memberInfoDao dao = memberInfoDao.getInstance();
		int ri = dao.userCheck(id, pw);
		
		//
		request.setAttribute("ri", ri);
		request.setAttribute("id", id);
	}
	
	
		
		
		
	
}
