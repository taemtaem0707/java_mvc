package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;
import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BUserinfoDeleteCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		
		request.setAttribute("pw", pw);
		
		request.setAttribute("id", id);
		
	}

		
		
		
	
}
