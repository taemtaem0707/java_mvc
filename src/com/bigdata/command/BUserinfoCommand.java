package com.bigdata.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BUserinfoCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		memberInfoDao dao = memberInfoDao.getInstance();
		memberInfoDto dto = dao.getMemberInfo(id);
		String name = dto.getName();
		System.out.println(name);
		String n_name = dto.getN_name();
		String email = dto.getEmail();
		
		request.setAttribute("name", name);
		request.setAttribute("n_name", n_name);
		request.setAttribute("email", email);
	}
}
