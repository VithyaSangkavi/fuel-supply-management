package com.itp.controller;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import com.itp.service.StaffInterface;
import com.itp.service.StaffInterfaceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteStaff
 */
@WebServlet("/DeleteStaff")
public class DeleteStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaff() {
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
		response.setContentType("text/html");

		String StaffID = request.getParameter("StaffID");			
		
		
		StaffInterface iss = new StaffInterfaceImpl();
		iss.RemoveStaff(StaffID);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStaff.jsp");
		dispatcher.forward(request, response);
		
	}

}
