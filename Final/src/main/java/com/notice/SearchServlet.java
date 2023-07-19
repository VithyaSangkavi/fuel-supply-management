package com.notice;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nTitle = request.getParameter("nid");
		
		try {
			List<Notice> noticeDet = NoticeDBUtil.search(nTitle);
			request.setAttribute("noticeDet", noticeDet);
		}catch(Exception e){
			e.printStackTrace();
		}

		
		RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
				
	}

}
