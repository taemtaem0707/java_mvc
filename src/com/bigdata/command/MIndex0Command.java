package com.bigdata.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class MIndex0Command implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		memberInfoDao dao = memberInfoDao.getInstance();
		ArrayList<memberInfoDto> memberList = dao.getMemberList();
		
		request.setAttribute("memberList", memberList);
	}
}
