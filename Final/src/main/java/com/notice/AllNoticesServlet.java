package com.notice;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AllNoticesServlet")
public class AllNoticesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String allNotices = request.getParameter("allnotices");
		/*catching errors*/
		try {
			
			List<Notice> allnotDet = NoticeDBUtil.getAllNotices(allNotices);
			request.setAttribute("allnotDet", allnotDet);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
	}

}
