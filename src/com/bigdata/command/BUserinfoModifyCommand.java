package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;
import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BUserinfoModifyCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	
		String id = request.getParameter("id");
		memberInfoDao dao = memberInfoDao.getInstance();
		memberInfoDto dto = dao.getMemberInfo(id);
		String pw = dto.getPw();
		String name = dto.getName();
		String n_name = dto.getN_name();
		String email = dto.getEmail();
				
				
	
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("n_name", n_name);
		request.setAttribute("email", email);
		
	}

		
		
		
	
}
