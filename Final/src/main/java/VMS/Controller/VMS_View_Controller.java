package VMS.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

import VMS.Dao.VMS_Finish_DAO;
import VMS.Dao.VMS_MRR_DAO;
import VMS.Model.VMS_Create;

/**
 * Servlet implementation class VMS_MRR_Controller
 */

@WebServlet("/view")
public class VMS_View_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VMS_MRR_DAO rDao = new VMS_MRR_DAO();
	private VMS_Finish_DAO fDao = new VMS_Finish_DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		RequestDispatcher rd = null;
		
		String status = request.getParameter("status");
		String fLimit = request.getParameter("fLimit");
		String rfuel = request.getParameter("rfuel");
		String date = request.getParameter("date");
		
		float FLimit = Float.parseFloat(fLimit);
		float RFuel = Float.parseFloat(rfuel);
		
		String action = request.getParameter("action");
		String np = (String)session.getAttribute("np");
		
		if("renew".equals(action)) {
			
			

			if("yes".equals(status))
			{
				Date tDate = new Date();
				
				java.sql.Date date1 = convertDate(tDate);
				
				String dt = date1.toString();
				
					VMS_Create MRR = new VMS_Create();
					MRR.setDate(dt);
					MRR.setRemainFuel(FLimit);
					MRR.setPlate_number(np);
					
					//rd.forward(request, response);
					rd = request.getRequestDispatcher("MRR_success.jsp");
					rd.forward(request, response);

					try {
						rDao.MRR(MRR);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				
					
	
			}
			
			else{
				try {					
					rd = request.getRequestDispatcher("MRR_fail.jsp");
					rd.forward(request, response);
					
				}catch(Exception e) {
					//get the exception
					e.printStackTrace();
				}
			}
			}
		
		if("finish".equals(action)) {
			
			
			VMS_Create finish = new VMS_Create();
			finish.setRemainFuel(RFuel);
			finish.setPlate_number(np);
			
		
			// redirect to the login page after edit their account
			rd = request.getRequestDispatcher("indexVehicle.jsp");
			
			
			rd.forward(request, response);
			
			
			try {
					fDao.finish(finish);
				
			}catch(Exception e) {
				//get the exception
				e.printStackTrace();
			}
			}
	

		
	}
		
		
	private static java.sql.Date convertDate(Date date){
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
		
		
		
		

}


