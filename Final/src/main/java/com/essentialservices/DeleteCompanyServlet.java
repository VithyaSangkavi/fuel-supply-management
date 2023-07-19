package com.essentialservices;

import java.io.IOException;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/DeleteCompanyServlet")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cid = request.getParameter("cId");
		boolean isTrue;
		
		isTrue = EssentialServicesDBUtil.deleteCompany(cid);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("companyinsert.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			List<EssentialServices> essDetails = EssentialServicesDBUtil.getCompanyDetails(cid);
			request.setAttribute("essDetails", essDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("companyaccount.jsp");
			dispatcher.forward(request, response);
		}
	}

}
