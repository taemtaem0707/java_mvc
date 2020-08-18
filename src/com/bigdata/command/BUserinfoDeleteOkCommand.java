package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;
import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BUserinfoDeleteOkCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		memberInfoDao dao = memberInfoDao.getInstance();
		memberInfoDto dto = dao.getMemberInfo(id);
		dto = dao.getMemberInfo(id);
		System.out.println(dto.getPw());
		
		int ri = 0;
		
		if(pw.equals(dto.getPw())) { 
			ri = dao.memberInfoDelete(id);
			
		}else if(!pw.equals(dto.getPw())) {
			ri = 0;
			
		};
		
		request.setAttribute("ri", ri);
	
		request.setAttribute("id", id);

	}

		
		
		
	
}
