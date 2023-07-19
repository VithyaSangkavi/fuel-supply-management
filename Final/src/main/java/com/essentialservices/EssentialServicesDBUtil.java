package com.essentialservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;








public class EssentialServicesDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static List<EssentialServices> validate(String companyId, String password){
		
		ArrayList<EssentialServices> ess = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from essentialservices where companyID='"+companyId+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String cid = rs.getString(1);
				String cname = rs.getString(2);
				String fname = rs.getString(3);
				String lname = rs.getString(4);
				String sType  = rs.getString(5);
				String reason = rs.getString(6);
				String address = rs.getString(7); 
				String email = rs.getString(8);
				int fLimit = rs.getInt(9);
				String letter = rs.getString(10);
				String passU = rs.getString(11);
				
				EssentialServices e = new EssentialServices(cid,cname,fname,lname,sType,reason, address,  email,  fLimit,  letter,  passU);
				ess.add(e);
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ess;
	}
	
public static boolean insertcompany(String cName, String fName, String lName, String type, String reason, String address, String email,String limit,String letter,String password) {
        
        boolean isSuccess = false;
        
        
        
        
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            
            
             String sql1= "select companyId from essentialservices ORDER BY companyId DESC LIMIT 1;";
             ResultSet rs1=stmt.executeQuery(sql1);
             
             String id = null;
             if(rs1.next()) {
                 
                 id=rs1.getString(1);
         
             }





           int a = Character.getNumericValue(id.charAt(1));
             int b = Character.getNumericValue(id.charAt(2));
             int c = Character.getNumericValue(id.charAt(3));
             int d = Character.getNumericValue(id.charAt(4));
             

           int z=a*1000+b*100+c*10+d*1+1;
             
             String id2=null;
             if (z>=0 && z<10) {
                  id2 = "E000"+z;
             }else if(z>=10 && z<100) {
                  id2 = "E00"+z;
                 
             }else if(z>=100 && z<1000) {
                 
                  id2 = "E0"+z;
             }else if(z>=1000) {
                 
                  id2 = "E"+z;
             }        
             
             
             
            String sql = "insert into essentialservices values ('"+id2+"','"+cName+"','"+fName+"','"+lName+"','"+type+"','"+reason+"','"+address+"','"+email+"','"+limit+"','"+letter+"','"+password+"')";
            int rs = stmt.executeUpdate(sql);
            
            
            
            if(rs > 0) {
                isSuccess = true;
            } else {
                isSuccess = false;
            }    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
     
        return isSuccess;
    }

	 
	 public static boolean updatecompany(String cid,String cname,String fname,String lname,String sType,String reason,String address,String  email, String fLimit, String letter, String password) {
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "update essentialservices set companyName='"+cname+"',managerFirstName='"+fname+"',managerLastName ='"+lname+"',serviceType ='"+sType+"',reason='"+reason+"',address ='"+address+"',email ='"+email+"',fuelLimit ='"+fLimit+"',municipalcounciLetterl ='"+letter+"',password ='"+password+"'"
	    				+ "where companyId='"+cid+"'";
	    		int rs = stmt.executeUpdate(sql);
	    		
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
	 
	 public static List<EssentialServices> getCompanyDetails(String cid) {
	    	
	    	
	    	ArrayList<EssentialServices> ess = new ArrayList<>();
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from EssentialServices where companyId='"+cid+"'";
	    		rs = stmt.executeQuery(sql);
	    		
	    		while(rs.next()) {
	    		

	    			String coid = rs.getString(1);
	    			String cname= rs.getString(2);
	    			String fname= rs.getString(3);
	    			String lname= rs.getString(4);
	    			String sType= rs.getString(5);
	    			String reason= rs.getString(6);
	    		    String address= rs.getString(7);
	    		    String email= rs.getString(8);
	    		    int fLimit= rs.getInt(9);
	    		    String letter= rs.getString(10);
	    		    String password = rs.getString(11);
	    			
	    			
	    		    EssentialServices e = new EssentialServices(coid,cname,fname,lname,sType,reason,address,email,fLimit,letter,password);
	    			ess.add(e);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return ess;	
	    }
	 
	 public static boolean deleteCompany(String cid) {
	    	
	    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "delete from essentialservices where companyId='"+cid+"'";
	    		int r = stmt.executeUpdate(sql);
	    		
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
