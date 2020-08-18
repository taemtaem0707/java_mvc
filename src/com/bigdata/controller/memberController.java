package com.bigdata.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bigdata.command.MCommand;
import com.bigdata.command.MIndex0Command;

@WebServlet("*.member")
public class memberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public memberController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("actionDo");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		String viewPage = null;
		MCommand command = null;
		

		if(uri.equals("/bigdata/mvcboard/index0.member") || com.equals("/")) {
			System.out.println("index0 관련 처리");		
			command = new MIndex0Command();
			command.execute(request, response);
			viewPage = "/mvcboard/index0.jsp";

		}
		if(uri.equals("/bigdata/mvcboardjstl/index0_mvc_jstl.member")) {
			System.out.println("index0_mvc_jstl 관련 처리");		
			command = new MIndex0Command();
			command.execute(request, response);
			viewPage = "/mvcboardjstl/index0_mvc_jstl.jsp";

		}

		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
