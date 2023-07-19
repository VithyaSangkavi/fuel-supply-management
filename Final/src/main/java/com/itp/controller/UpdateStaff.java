package com.itp.controller;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itp.model.Staff;
import com.itp.service.StaffInterface;
import com.itp.service.StaffInterfaceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStaff
 */
@WebServlet("/UpdateStaff")
public class UpdateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Date date;
		
		response.setContentType("text/html");

		Staff s1 = new Staff();
		String StaffID = request.getParameter("StaffID");	
		s1.setStaffID(StaffID);
		s1.setFirstName(request.getParameter("FirstName"));
		s1.setLastName(request.getParameter("LastName"));
		s1.setNIC(request.getParameter("NIC"));
		s1.setAddress(request.getParameter("Address"));
		s1.setEmail(request.getParameter("Email"));
		s1.setAccNo(request.getParameter("AccNo"));
		s1.setPassword(request.getParameter("NIC"));
		s1.setStaffType(request.getParameter("StaffType"));
		s1.setContactYears(Integer.parseInt(request.getParameter("ContactYears")));
		s1.setBasicSalary(Double.parseDouble(request.getParameter("BasicSalary")));
		s1.setOt(Double.parseDouble(request.getParameter("Ot")));
	
		
		StaffInterface iss = new StaffInterfaceImpl();
		iss.UpdateStaff(StaffID, s1);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStaff.jsp");
		dispatcher.forward(request, response);
	}

}
