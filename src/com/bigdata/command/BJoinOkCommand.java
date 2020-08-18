package com.bigdata.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberInfo.memberInfoDao;
import memberInfo.memberInfoDto;

public class BJoinOkCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String n_name = request.getParameter("n_name");
		String email = request.getParameter("email");
		memberInfoDao dao = memberInfoDao.getInstance();
		memberInfoDto dto = new memberInfoDto(id, pw, name, n_name, email);
		int ri = dao.confirmId(dto.getId());  // 수정 시 입력 값을 바꿀 위치 - memberInfoDto의 게터, 세터에 따라 값 수정
		int ri2 = dao.memberInfoInsert(dto);  // 수정 시 입력 값을 바꿀 위치 - memberInfoDto의 게터, 세터에 따라 값 수정
		
		
		
		//
		request.setAttribute("ri", ri);
		request.setAttribute("ri2", ri2);

		
	}
}
