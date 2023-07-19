package com.notice;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("noticeId");
		String nTitle = request.getParameter("noticeTitle");
		String notice_type = request.getParameter("ntype");
		int nType = Integer.parseInt(notice_type);
		String nDesc = request.getParameter("ndesc");
		String nEmail = request.getParameter("email");
		String upbtn = request.getParameter("updatebtn");
		String delbtn = request.getParameter("deletebtn");
		
		boolean isTrue;
		boolean isCorrect;
		
		if(upbtn != null) {
			isTrue = NoticeDBUtil.updateNotice(id, nTitle, nType, nDesc, nEmail);
			if(isTrue == true) {
				RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
				dis.forward(request, response);
			}else if(isTrue == false) {
				RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
				dis2.forward(request, response);
			}
		}
		
		
		if(delbtn != null) {
			isCorrect = NoticeDBUtil.deleteNotice(id);
			if(isCorrect == true) {
				RequestDispatcher dis3 = request.getRequestDispatcher("search.jsp");
				dis3.forward(request, response);
			}else {
				RequestDispatcher dis4 = request.getRequestDispatcher("unsuccess.jsp");
				dis4.forward(request, response);
			}
		}
		
		
		

	}

}
