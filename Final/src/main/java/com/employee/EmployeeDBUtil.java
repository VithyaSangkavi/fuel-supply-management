package com.employee;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DBConnect;

public class EmployeeDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
 
	public static List<Employee> validate(String month, String totalLeave){
		
		ArrayList<Employee> emp = new ArrayList<>();
		
		
		
		try {
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from attendance where month='"+month+"' and totalLeave='"+totalLeave+"'";
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String totalOT = rs.getString(2);
				String totalleave = rs.getString(3);
				String month1 = rs.getString(4);
				String totalDaysWorked = rs.getString(5);
				
				Employee em = new Employee(id,totalOT,totalleave,month1,totalDaysWorked);
				emp.add(em);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return emp;
		
	}
	
	public static boolean insertemployee(String staffID,String totalOT, String totalLeave, String month, String totalDaysWorked){
	
	boolean isSuccess = false;
	
	
	try {
		con = DBConnect.getConnection();
		stat = con.createStatement();
		String sql = "insert into attendance (staffID,totalOT, totalLeave, month, totalDaysWorked) values ('"+staffID+"','"+totalOT+"','"+totalLeave+"','"+month+"','"+totalDaysWorked+"')";
		int rs = stat.executeUpdate(sql);
		
		if(rs > 0) {
			isSuccess = true;
		} else {
			isSuccess = false;
		}


	}
	
	catch (Exception e){
		
		e.printStackTrace();
		
	}
	
	return isSuccess;
	
	}
	
	public static boolean updateslip(String id, String totalOT, String totalLeave, String month, String totalDaysWorked) {
		
		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "update attendance set totalOT ='"+totalOT+"',totalLeave = '"+totalLeave+"',month = '"+month+"', totalDaysWorked = '"+totalDaysWorked+"'"
					+ "where attendanceID = '"+id+"'";
			
			int rs = stat.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
		
	}
	
	
	
	
	public static List<Employee> getEmployeeDetails(String Id){
		
			int convertedID = Integer.parseInt(Id);
		
			ArrayList<Employee> emp = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "select * from attendance where attendanceID = '"+convertedID+"'";
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String totalOT = rs.getString(2);
				String totalLeave = rs.getString(3);
				String month = rs.getString(4);
				String totalDaysWorked = rs.getString(5);
				
				Employee e = new Employee(id,totalOT,totalLeave,month,totalDaysWorked);
				emp.add(e);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public static List<Employee> getSlipDetails(String Id){
		
		String convID = Id;
	
		ArrayList<Employee> em = new ArrayList<>();
	
	try {
		
		con = DBConnect.getConnection();
		stat = con.createStatement();
		String sql = "select * from attendance where attendanceID = '"+convID+"'";
		rs = stat.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String totalOT = rs.getString(2);
			String totalLeave = rs.getString(3);
			String month = rs.getString(4);
			String totalDaysWorked = rs.getString(5);
			
			Employee e = new Employee(id,totalOT,totalLeave,month,totalDaysWorked);
			em.add(e);
		}
		
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return em;
}

	
	public static boolean deleteSlip(String id) {
		
		String convId = id;
		
		try {
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			String sql = "delete from attendance where attendanceID= '"+convId+"'";
			int r = stat.executeUpdate(sql);
			
			if (r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
 