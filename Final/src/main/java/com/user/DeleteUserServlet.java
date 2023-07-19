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

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nic=request.getParameter("nic");
		
		boolean isTrue;
		
		isTrue=UserDbUtil.deleteUser(nic);
		
		if(isTrue==true) {
			RequestDispatcher dis=request.getRequestDispatcher("UserRegistration.jsp");
			dis.forward(request, response);
		}else {
			PrintWriter out =response.getWriter();
	        JOptionPane.showMessageDialog(null, "Delete Unsuccesful");
		    response.sendRedirect("UserHomepage.jsp");
			
		}
		
		
	}

}
