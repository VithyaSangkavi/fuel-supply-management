package com.essentialservices;

import java.io.IOException;

import java.util.List;

import com.user.UserDbUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/LoginServletCompany")
public class LoginServletCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String companyId = request.getParameter("cid");
		String password = request.getParameter("pass");
		
		try {
			List<EssentialServices> essDetails = EssentialServicesDBUtil.validate(companyId, password);
			request.setAttribute("essDetails", essDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("companyaccount.jsp");
		dis.forward(request, response);
	}

}
