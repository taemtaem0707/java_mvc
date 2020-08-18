package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.BoardDao;
import memberInfo.BoardDto;
import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BUserinfoModifyOkCommand implements BCommand {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String n_name = request.getParameter("n_name");
		String email = request.getParameter("email");
	
		memberInfoDao dao = memberInfoDao.getInstance();
		memberInfoDto dto = dao.getMemberInfo(id);
		System.out.println(dto.getPw());
		
		System.out.println(pw);
		
		int ri = 0;
		if(pw.equals(dto.getPw())){
			dto = new memberInfoDto(id, pw, name, n_name, email);
			ri = dao.memberInfoModify(dto);
		}else {
			ri = 5;
		}
		
		System.out.println(ri);
		request.setAttribute("ri", ri);
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("n_name", n_name);
		request.setAttribute("email", email);
		
	}

		
		
		
	
}
