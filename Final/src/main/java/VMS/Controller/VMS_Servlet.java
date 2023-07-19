package VMS.Controller;
import VMS.Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

import VMS.Dao.VMS_Create_DAO;
import VMS.Dao.VMS_MRR_DAO;

/**
 * Servlet implementation class VMS_Servlet
 */

@WebServlet("/servlet")
public class VMS_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private VMS_Create_DAO cDao = new VMS_Create_DAO();
	private VMS_MRR_DAO rDao = new VMS_MRR_DAO();

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String cNumber = request.getParameter("cNumber");
		String pNumber = request.getParameter("pNumber");
		String vType = request.getParameter("vType");
		String fLimit = request.getParameter("fLimit");
		String fType = request.getParameter("fType");
		String date = request.getParameter("date");
		
		int FLimit = Integer.parseInt(fLimit);
		
		RequestDispatcher rd = null;
		
		String action = request.getParameter("action");
		
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		

		
		java.sql.Date sqlDate = null;
		
		String uid = (String)session.getAttribute("userID");
		
		//System.out.println(uid);
		
		if(cNumber.length() == 17) {
			System.out.println("Success");
		}else {
			System.out.println("Failed");
		}

		
		if("register".equals(action)) {
			VMS_Create rVehicle = new VMS_Create();
			rVehicle.setChassis_Number(cNumber);
			rVehicle.setPlate_number(pNumber);
			rVehicle.setVtype(vType);
			rVehicle.setFuelLimit(FLimit);
			rVehicle.setDate(date);
			rVehicle.setFuelType(fType);
			rVehicle.setRemainFuel(FLimit);
			rVehicle.setID(uid);
			
			// redirect to the login page after edit their account
			rd = request.getRequestDispatcher("create_success.jsp");
			
			
			rd.forward(request, response);
			
			try {
				cDao.registerVehicle(rVehicle);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
		
		

				
	

}
