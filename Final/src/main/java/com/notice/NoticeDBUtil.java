package com.notice;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class NoticeDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	/*search notices from database according to the given title*/
	public static List<Notice> search(String noticeTitle){
		String ntype;
		ArrayList<Notice> notice = new ArrayList<>();
	
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from notice where notice_title LIKE '%"+ noticeTitle +"%'";
			//validate
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String notice_title = rs.getString(2);
				int notice_type = rs.getInt(3);
				if(notice_type == 1) {
					 ntype = "Priority Notice";
				}else {
					 ntype = "Normal Notice";
				}
				Timestamp date = rs.getTimestamp(4);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:m m:ss");  
				String strDate = dateFormat.format(date);
				String notice_desc = rs.getString(5);
				String email = rs.getString(6);
				
				Notice not = new Notice(id,notice_title,ntype,strDate,notice_desc,email);
				notice.add(not);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	/* get all the notices of the current month*/
	public static List<Notice> getAllNotices(String allnotices){
		String ntype;
		ArrayList<Notice> notice = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from notice WHERE MONTH(notice_date) = MONTH(now())";
			
			//validate
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String notice_title = rs.getString(2);
				int notice_type = rs.getInt(3);
				if(notice_type == 1) {
					 ntype = "Priority Notice";
				}else {
					 ntype = "Normal Notice";
				}
				Timestamp date = rs.getTimestamp(4);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:m m:ss");  
				String strDate = dateFormat.format(date);
				String notice_desc = rs.getString(5);
				String email = rs.getString(6);
				
				Notice not = new Notice(id,notice_title,ntype,strDate,notice_desc,email);
				notice.add(not);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return notice;
		
	}
	
	/*Insert notice to database*/
	
	public static boolean insertNotice(String nTitle,int nType,Timestamp nDate,String nDesc,String email) {
		isSuccess = false;
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO notice VALUES(0,'"+ nTitle +"','"+ nType +"','"+ nDate +"','"+ nDesc +"','"+ email +"')";
			String sql1 = "INSERT INTO notice_email VALUES(last_insert_id(),'"+email+"')";
			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql1);
			if(rs > 0 && rs1>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	/* Update notice*/
	public static boolean updateNotice(String id,String nTitle,int nType,String nDesc,String email) {
		
		 try {
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			 String sql = "UPDATE notice SET notice_title='"+nTitle+"',notice_type='"+nType+"',notice_desc='"+nDesc+"',email='"+email+"'"+"WHERE notice_no='"+id+"'";
			 String sql2 = "UPDATE notice_email SET ownerEmail='"+email+"' WHERE notice_no = '"+id+"'";
			 int rs = stmt.executeUpdate(sql);
			 int rs2 = stmt.executeUpdate(sql2);
			 if(rs > 0 && rs2 >0) {
				 isSuccess = true;
			 }else {
				 isSuccess = false;
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return isSuccess;
	}
	/* delete the notice*/
	public static boolean deleteNotice(String id) {
		int convId = Integer.parseInt(id);
		
		try {
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			 String sql = "DELETE FROM notice WHERE notice_no ='"+ convId +"'";
			 int rs = stmt.executeUpdate(sql);
			
			 if(rs > 0) {
				 isSuccess = true;
			 }else {
				 isSuccess = false;
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	/* get the notices with high priority for the user*/
	public static List<Notice> getpriority(){
		String ntype;
		ArrayList<Notice> prnotices = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM notice WHERE notice_type = 1 AND MONTH(notice_date) = MONTH(now())";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String notice_title = rs.getString(2);
				int notice_type = rs.getInt(3);
				if(notice_type == 1) {
					 ntype = "Priority Notice";
				}else {
					 ntype = "Normal Notice";
				}
				Timestamp date = rs.getTimestamp(4);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:m m:ss");  
				String strDate = dateFormat.format(date);
				String notice_desc = rs.getString(5);
				String email = rs.getString(6);
				
				Notice not = new Notice(id,notice_title,ntype,strDate,notice_desc,email);
				prnotices.add(not);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prnotices;
	}
	/* generate a report using the report NoticeReport Model Class*/
	public static List<NoticeReport> getReport(){
		ArrayList<NoticeReport> report = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT COUNT(notice_no),monthname(notice_date),year(notice_date) FROM notice GROUP BY MONTH(notice_date) ORDER by year(notice_date)";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int notice_count = rs.getInt(1);
				String month = rs.getString(2);
				int year = rs.getInt(3);
				
				NoticeReport notrep = new NoticeReport(notice_count,month,year);
				report.add(notrep);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	
	/*get all the notices for the front end or user*/
	public static List<Notice> getNoticeForUsers(){
		String ntype;
		ArrayList<Notice> notice = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from notice WHERE MONTH(notice_date) = MONTH(now())";
			
			//validate
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String notice_title = rs.getString(2);
				int notice_type = rs.getInt(3);
				if(notice_type == 1) {
					 ntype = "Priority Notice";
				}else {
					 ntype = "Normal Notice";
				}
				Timestamp date = rs.getTimestamp(4);
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:m m:ss");  
				String strDate = dateFormat.format(date);
				String notice_desc = rs.getString(5);
				String email = rs.getString(6);
				
				Notice not = new Notice(id,notice_title,ntype,strDate,notice_desc,email);
				notice.add(not);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	
}
