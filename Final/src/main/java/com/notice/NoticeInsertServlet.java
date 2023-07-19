package com.notice;

import java.io.IOException;
import java.sql.Timestamp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NoticeInsertServlet")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nTitle = request.getParameter("title");
		String notic_type = request.getParameter("ntype");
		int nType = Integer.parseInt(notic_type);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String nDesc = request.getParameter("ndesc");
		String email = request.getParameter("email");
		
		boolean isTrue;
		
		isTrue = NoticeDBUtil.insertNotice(nTitle, nType, timestamp, nDesc, email);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
