package com.employee;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/employeeinsert")
public class employeeinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String staffID = request.getParameter("sid");
		String totalOT = request.getParameter("tot");
		String totalLeave = request.getParameter("tlt");
		String month =request.getParameter("month");
		String totalDaysWorked = request.getParameter("tdw");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.insertemployee(staffID,totalOT, totalLeave, month, totalDaysWorked);
		
		if(isTrue == true) {
			
			HttpSession open = request.getSession();
			open.setAttribute("sid", staffID);
			
			List<Employee> empDetails = EmployeeDBUtil.getSlipDetails(staffID);
			request.setAttribute("empDetails", empDetails);
			RequestDispatcher dis = request.getRequestDispatcher("indexAttendance.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccessAttendance.jsp");
			dis2.forward(request, response);
		}
	}

}
