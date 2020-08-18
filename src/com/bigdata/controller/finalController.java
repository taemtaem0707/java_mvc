package com.bigdata.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.command.BCommand;
import com.bigdata.command.BDeleteCommand;
import com.bigdata.command.BDeleteOkCommand;
import com.bigdata.command.BJoinCommand;
import com.bigdata.command.BJoinOkCommand;
import com.bigdata.command.BListCommand;
import com.bigdata.command.BLoginCommand;
import com.bigdata.command.BLoginOkCommand;
import com.bigdata.command.BMainCommand;
import com.bigdata.command.BReplyCommand;
import com.bigdata.command.BReplyOkCommand;
import com.bigdata.command.BUpdateCommand;
import com.bigdata.command.BUpdateOkCommand;
import com.bigdata.command.BUserinfoCommand;
import com.bigdata.command.BUserinfoDeleteCommand;
import com.bigdata.command.BUserinfoDeleteOkCommand;
import com.bigdata.command.BUserinfoModifyCommand;
import com.bigdata.command.BUserinfoModifyOkCommand;
import com.bigdata.command.BViewCommand;
import com.bigdata.command.MIndex0Command;

@WebServlet("*.do")
public class finalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public finalController() {
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

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());

		String viewPage = null;
		BCommand command = null;
		System.out.println(com);

		if(com.equals("/finalmvcboard/main/main.do") || com.equals("/")) {
			System.out.println("main 관련 처리");		
			command = new BMainCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/main/main.jsp";
		}
		
		
		
		
		if(com.equals("/finalmvcboard/user/login.do")) {
			System.out.println("login 관련 처리");		
			viewPage = "/finalmvcboard/user/login.jsp";
		}
		if(com.equals("/finalmvcboard/user/loginOk.do")) {
			System.out.println("loginOk 관련 처리");		
			command = new BLoginOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/loginOk.jsp";
		}
		if(com.equals("/finalmvcboard/user/logout.do")) {
			System.out.println("logout 관련 처리");	
			command = new BLoginOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/logout.jsp";
		}
		
		
		
		if(com.equals("/finalmvcboard/user/userinfo.do")) {
			System.out.println("userinfo 관련 처리");	
			command = new BUserinfoCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/userinfo.jsp";
		}
		if(com.equals("/finalmvcboard/user/delete.do")) {
			System.out.println("userdelete 관련 처리");	
			command = new BUserinfoDeleteCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/delete.jsp";
		}
		if(com.equals("/finalmvcboard/user/deleteOk.do")) {
			System.out.println("userdeleteOk 관련 처리");	
			command = new BUserinfoDeleteOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/deleteOk.jsp";
		}
		if(com.equals("/finalmvcboard/user/join.do")) {
			System.out.println("join 관련 처리");		
			viewPage = "/finalmvcboard/user/join.jsp";
		}
		if(com.equals("/finalmvcboard/user/joinOk.do")) {
			System.out.println("joinOk 관련 처리");		
			command = new BJoinOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/joinOk.jsp";
		}
		if(com.equals("/finalmvcboard/user/modify.do")) {
			System.out.println("modify 관련 처리");		
			command = new BUserinfoModifyCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/modify.jsp";
		}
		if(com.equals("/finalmvcboard/user/modifyOk.do")) {
			System.out.println("modifyOk 관련 처리");		
			command = new BUserinfoModifyOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/user/modifyOk.jsp";
		}
		
		
		
		
		
		
		
		if(com.equals("/finalmvcboard/board/list.do")) {
			System.out.println("list 관련 처리");		
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/list.jsp";
		}
		if(com.equals("/finalmvcboard/board/view.do")) {
			System.out.println("view 관련 처리");		
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/view.jsp";
		}
		if(com.equals("/finalmvcboard/board/delete.do")) {
			System.out.println("boardDelete 관련 처리");		
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/delete.jsp";
		}
		if(com.equals("/finalmvcboard/board/deleteOk.do")) {
			System.out.println("boardDeleteOk 관련 처리");		
			command = new BDeleteOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/deleteOk.jsp";
		}
		if(com.equals("/finalmvcboard/board/update.do")) {
			System.out.println("update 관련 처리");		
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/update.jsp";
		}
		if(com.equals("/finalmvcboard/board/updateOk.do")) {
			System.out.println("updateOk 관련 처리");		
			command = new BUpdateOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/updateOk.jsp";
		}
		if(com.equals("/finalmvcboard/board/reply.do")) {
			System.out.println("reply 관련 처리");		
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/reply.jsp";
		}
		if(com.equals("/finalmvcboard/board/replyOk.do")) {
			System.out.println("replyOk 관련 처리");		
			command = new BReplyOkCommand();
			command.execute(request, response);
			viewPage = "/finalmvcboard/board/replyOk.jsp";
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
