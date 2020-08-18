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
import com.bigdata.command.BReplyCommand;
import com.bigdata.command.BReplyOkCommand;
import com.bigdata.command.BSearchListCommand;
import com.bigdata.command.BUpdateCommand;
import com.bigdata.command.BUpdateOkCommand;
import com.bigdata.command.BViewCommand;
import com.bigdata.command.BWriteCommand;
import com.bigdata.command.BWriteOkCommand;

@WebServlet("*.doo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
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

		if(com.equals("/mvcboard/list.do")) {
			System.out.println("List 관련 처리");
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";

		}else if(com.equals("/mvcboard/view.do")) {
			System.out.println("view 관련 처리");		
			command = new BViewCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/view.jsp";

		}else if(com.equals("/mvcboard/delete.do")) {
			System.out.println("delete 관련 처리");		
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/delete.jsp";

		}else if(com.equals("/mvcboard/write.do")) {
			System.out.println("write 관련 처리");		
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/write.jsp";
		}
		else if(com.equals("/mvcboard/writeOk.do")) {
			System.out.println("writeOk 관련 처리");		
			command = new BWriteOkCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/writeOk.jsp";
		}else if(com.equals("/login/login.do")) {
			System.out.println("login 관련 처리");		
			command = new BLoginCommand();
			command.execute(request, response);
			viewPage = "/login/login.jsp";
		}
		else if(com.equals("/login/loginOk.do")) {
			System.out.println("loginOk 관련 처리");		
			command = new BLoginOkCommand();
			command.execute(request, response);
			viewPage = "/login/loginOk.jsp";
		}
		else if(com.equals("/join/join.do")) {
			System.out.println("join 관련 처리");		
			command = new BJoinCommand();
			command.execute(request, response);
			viewPage = "/join/join.jsp";
		}
		else if(com.equals("/join/joinOk.do")) {
			System.out.println("joinOk 관련 처리");		
			command = new BJoinOkCommand();
			command.execute(request, response);
			viewPage = "/join/joinOk.jsp";
		}
		else if(com.equals("/mvcboard/update.do")) {
			System.out.println("update 관련 처리");		
			command = new BUpdateCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/update.jsp";
		}
		else if(com.equals("/mvcboard/updateOk.do")) {
			System.out.println("updateOk 관련 처리");		
			command = new BUpdateOkCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/updateOk.jsp";
		}
		else if(com.equals("/mvcboard/deleteOk.do")) {
			System.out.println("deleteOk 관련 처리");		
			command = new BDeleteOkCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/deleteOk.jsp";
		}
		else if(com.equals("/mvcboard/reply.do")) {
			System.out.println("reply 관련 처리");		
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/reply.jsp";
		}
		else if(com.equals("/mvcboard/replyOk.do")) {
			System.out.println("replyOk 관련 처리");		
			command = new BReplyOkCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/replyOk.jsp";
		}
		else if(com.equals("/mvcboardjstl/list_mvc_jstl.do")) {
			System.out.println("list_mvc_jstl 관련 처리");		
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "/mvcboardjstl/list_mvc_jstl.jsp";
		}
		else if(com.equals("/mvcboard/searchList.do")) {
			System.out.println("searchList 관련 처리");		
			command = new BSearchListCommand();
			command.execute(request, response);
			viewPage = "/mvcboard/searchList.jsp";
		}
		else if(com.equals("/mvcboardjstl/searchList_mvc_jstl.do")) {
			System.out.println("searchList_mvc_jstl 관련 처리");		
			command = new BSearchListCommand();
			command.execute(request, response);
			viewPage = "/mvcboardjstl/searchList_mvc_jstl.jsp";
		}
		else if(com.equals("/mvcboardjstl/join_mvc_jstl.do")) {
			System.out.println("join_mvc_jstl 관련 처리");		
			command = new BSearchListCommand();
			command.execute(request, response);
			viewPage = "/mvcboardjstl/join_mvc_jstl.jsp";
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
