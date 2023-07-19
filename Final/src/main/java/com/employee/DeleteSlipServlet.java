package com.employee;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteSlipServlet")
public class DeleteSlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("slipid");
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.deleteSlip(id);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexAttendance.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteslip.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
