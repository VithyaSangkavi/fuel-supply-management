package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ForgotPass
 */
@WebServlet("/ForgotPass2")
public class ForgotPass2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		

		String nic=request.getParameter("username");
		String pswd=request.getParameter("password");
		
		
		
		boolean isTrue;
		
		isTrue=UserDbUtil.updateUserpass(nic, pswd);
		
		if(isTrue==true) {
			RequestDispatcher dis=request.getRequestDispatcher("UserLogin.jsp");
			dis.forward(request, response);
			
		}else {
		
			PrintWriter out =response.getWriter();
	        JOptionPane.showMessageDialog(null, "Update Unsuccesful");
		    response.sendRedirect("forgot2.jsp");
		}
	}

}
