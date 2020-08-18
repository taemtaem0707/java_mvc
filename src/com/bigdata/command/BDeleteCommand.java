package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;

public class BDeleteCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		
		//request
		request.setAttribute("idx", idx);
	}
}
