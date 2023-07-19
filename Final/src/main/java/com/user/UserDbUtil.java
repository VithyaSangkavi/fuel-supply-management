


package com.user;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.essentialservices.EssentialServices;

public class UserDbUtil {

	public static List<User> validate(String UserName,String password)	{
		
		ArrayList<User> us= new ArrayList<>();
		ArrayList<EssentialServices> ess = new ArrayList<>();
		//create database connection
		
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="Vithya24";
		
		//validate
		
		try {
			
			if(UserName.charAt(0)=='S'|| UserName.charAt(0)=='A') {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con =DriverManager.getConnection(url, user, psswd);
				Statement stmt=con.createStatement();
				String sql = "select * from staff where staffID='"+UserName+"' and password='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				if(rs.next()) {
					
					//change this later
					String id=rs.getString(1);
					String fname=rs.getString(2);
					String lname=rs.getString(3);
					String pswd=rs.getString(4);
					String nic=rs.getString(5);
					String otp=rs.getString(6);
					String email=rs.getString(7);
					String address=rs.getString(8);
			
					User u=new User(id,fname,lname,pswd,nic,otp,email,address);
					us.add(u);
				}else {
					us=null;
				}
			}else if(UserName.charAt(0)=='E') {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con =DriverManager.getConnection(url, user, psswd);
				Statement stmt=con.createStatement();
				String sql = "select * from essentialservice where companyID='"+UserName+"' and password='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
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
					
				}else {
					ess=null;
				}
			}else {
			
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con =DriverManager.getConnection(url, user, psswd);
				Statement stmt=con.createStatement();
				String sql = "select * from user where NIC='"+UserName+"' and password='"+password+"'";
				ResultSet rs=stmt.executeQuery(sql);
				
				if(rs.next()) {
					
					String id=rs.getString(1);
					String fname=rs.getString(2);
					String lname=rs.getString(3);
					String pswd=rs.getString(4);
					String nic=rs.getString(5);
					String otp=rs.getString(6);
					String email=rs.getString(7);
					String address=rs.getString(8);
			
					User u=new User(id,fname,lname,pswd,nic,otp,email,address);
					us.add(u);
				}
				else {
					us=null;
				}
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		
		return us;
	}
	
	public static boolean insertUser(String nic,String fname,String lname,String password,String otp,String email,String address) {
		boolean isSuccess=false;
		
		//create database connection
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="Vithya24";
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con =DriverManager.getConnection(url, user, psswd);
			Statement stmt=con.createStatement();
			
			String sql1= "select userID from user ORDER BY userID DESC LIMIT 1;";
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
				 id2 = "U000"+z;
			}else if(z>=10 && z<100) {
				 id2 = "U00"+z;
				
			}else if(z>=100 && z<1000) {
				
				 id2 = "U0"+z;
			}else if(z>=1000) {
				
				 id2 = "U"+z;
			}		
			
			
			
			String sql = "insert into user values ('"+id2+"','"+fname+"','"+lname+"','"+password+"','"+nic+"','"+otp+"','"+email+"','"+address+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}else {
				isSuccess=false;
				
			}
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		return isSuccess;
	}
	
	
	public static boolean updateUser(String nic,String pswd,String fname,String lname,String address) {
		
		boolean isSuccess=false;
		
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="VIthya24";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, user, psswd);
			Statement stmt=con.createStatement();
			
			String sql="update user set firstName='"+fname+"',lastName='"+lname+"',password='"+pswd+"',address='"+address+"' where NIC='"+nic+"'";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				
				isSuccess=true;
			}else {
				
				isSuccess=false;
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();	
		}
		
		
		
		return isSuccess;
	}
	public static boolean deleteUser(String nic) {
		
		boolean isSuccess=false;
		
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="Vithya24";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, user, psswd);
			Statement stmt=con.createStatement();
			
			String sql="delete from user where NIC='"+nic+"'";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				
				isSuccess=true;
			}else {
				
				isSuccess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	
	public static boolean updateUserpass(String nic,String password) {
		
		boolean isSuccess=false;
		
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="Vithya24";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, user, psswd);
			Statement stmt=con.createStatement();
			
			String sql="update user set password='"+password+"' where NIC='"+nic+"'";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				
				isSuccess=true;
			}else {
				
				isSuccess=false;
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();	
		}
		
		
		
		return isSuccess;
	}
	
	public static String RetriveDetforgotpass(String email) {
		
		String nic=null;
		
		String url= "jdbc:mysql://localhost:3306/fuelstaff";
		String user="root";
		String psswd="Vithya24";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, user, psswd);
			Statement stmt=con.createStatement();
			
			String sql="select * from user where email='"+email+"'";
			ResultSet rs=stmt.executeQuery(sql);

			if(rs.next()) {
				 nic=rs.getString(5);

			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();	
		}
		
		
		
		return nic;
	}
	
	
	
	
}
