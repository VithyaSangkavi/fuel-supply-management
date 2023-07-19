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
import jakarta.servlet.http.HttpSession;

import javax.swing.JOptionPane;

import com.essentialservices.EssentialServices;
import com.essentialservices.EssentialServicesDBUtil;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String password = request.getParameter("pswd");
		
		HttpSession h1 = request.getSession();
		
		try {
				List<User> usDet= UserDbUtil.validate(username, password);
				request.setAttribute("usDet", usDet);
		}catch(Exception e) {
			
			e.printStackTrace();
		}	
		//navigating to pages
		
		if(request.getAttribute("usDet")==null)
	    {
			PrintWriter out =response.getWriter();
	        JOptionPane.showMessageDialog(null, "Invalid NIC or Password ");
		    response.sendRedirect("UserLogin.jsp");
		
	    }else {
	    	if(username.charAt(0)=='A') {
		    	RequestDispatcher dis=request.getRequestDispatcher("AdminInterface.jsp");
				dis.forward(request, response);
	    	}else if(username.charAt(0)=='S') {
	    		RequestDispatcher dis=request.getRequestDispatcher("StaffInterface.jsp");
				dis.forward(request, response);
	    	}
	    	else if(username.charAt(0)=='E') {
	    		try {
	    			List<EssentialServices> essDetails = EssentialServicesDBUtil.validate(username, password);
	    			request.setAttribute("essDetails", essDetails);
	    		}catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    		
	    		RequestDispatcher dis=request.getRequestDispatcher("companyaccount.jsp");
				dis.forward(request, response);
	    	}
	    	else {
	    		h1.setAttribute("uid", username);
	    		RequestDispatcher dis=request.getRequestDispatcher("UserHomepage.jsp");
				dis.forward(request, response);
	    	}
	    }
		
	}

}
