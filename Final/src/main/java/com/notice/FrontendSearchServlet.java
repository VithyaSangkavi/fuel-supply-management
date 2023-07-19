package com.notice;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/FrontendSearchServlet")
public class FrontendSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notTitle = request.getParameter("usernid");
		try {
			List<Notice> noticeDet = NoticeDBUtil.search(notTitle);
			request.setAttribute("noticeDet", noticeDet);
		}catch(Exception e){
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("noticeboard.jsp");
		dis.forward(request, response);
	}

}
