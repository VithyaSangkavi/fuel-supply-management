package com.user;

import java.io.IOException;


import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String nic=request.getParameter("nic");
		String pswd=request.getParameter("pswd");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		
		
		boolean isTrue;
		
		isTrue=UserDbUtil.updateUser(nic, pswd, fname, lname, address);
		
		if(isTrue==true) {
			RequestDispatcher dis=request.getRequestDispatcher("Profile.jsp");
			dis.forward(request, response);
			
		}else {
		
			PrintWriter out =response.getWriter();
	        JOptionPane.showMessageDialog(null, "Update Unsuccesful");
		    response.sendRedirect("Profile.jsp");
		    
		}
	}

}
