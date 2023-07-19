package VMS.Controller;

import jakarta.servlet.RequestDispatcher;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import VMS.Dao.VMS_Edit_DAO;
import VMS.Dao.VMS_Finish_DAO;
import VMS.Model.VMS_Create;

/**
 * Servlet implementation class VMS_Edit_Controller
 */

@WebServlet("/edit")
public class VMS_Edit_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VMS_Edit_DAO eDao = new VMS_Edit_DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		
		String cNumber = request.getParameter("cNumber");
		String pNumber = request.getParameter("pNumber");
		String fType = request.getParameter("fType");
		String cfType = request.getParameter("CFUELID");
		
		
		String action = request.getParameter("action");
		
		if(cNumber.length() == 17) {
			System.out.println("Success");
		}else {
			System.out.println("Failed");
		}
		
		if(fType == null) {
			fType = cfType;
		}
			
			
		if("update".equals(action)) {
			VMS_Create rVehicle = new VMS_Create();
			rVehicle.setChassis_Number(cNumber);
			rVehicle.setFuelType(fType);
			rVehicle.setPlate_number(pNumber);
			
			
			// redirect to the login page after edit their account
			rd = request.getRequestDispatcher("Edit_success.jsp");
			
			
			rd.forward(request, response);
			
			try {
				eDao.edit(rVehicle);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
		
		
	

}
