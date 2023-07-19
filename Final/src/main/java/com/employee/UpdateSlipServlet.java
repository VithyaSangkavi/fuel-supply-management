package com.employee;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




 
@WebServlet("/UpdateSlipServlet")
public class UpdateSlipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("slipid");
		String totalOT = request.getParameter("totalot");
		String totalLeave = request.getParameter("totalleave");
		String month = request.getParameter("month");
		String totalDaysWorked = request.getParameter("totaldaysworked");
		
		boolean isTrue;
		
		isTrue = EmployeeDBUtil.updateslip(id, totalOT, totalLeave, month, totalDaysWorked);
		
		
		if(isTrue == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("indexAttendance.jsp");
			dis.forward(request, response);
			
		}
		
		
		else {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccessAttendance.jsp");
			dis.forward(request, response);
		}
		
	}

}
