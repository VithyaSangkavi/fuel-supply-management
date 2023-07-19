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
 * Servlet implementation class ForgotPass1
 */
@WebServlet("/ForgotPass1")
public class ForgotPass1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	String email=request.getParameter("email");
		
		try {
			
			String NIC= UserDbUtil.RetriveDetforgotpass(email);
			request.setAttribute("NIC", NIC);
			System.out.println(NIC);
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher dis= request.getRequestDispatcher("forgot2.jsp");
		dis.forward(request, response);
		
	}

}
