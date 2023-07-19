package com.essentialservices;

public class EssentialServices {
	
	private String cid;
	private String cname;
	private String fname;
	private String lname;
	private String sType;
	private String reason;
	private String address;
	private String email;	
	private int fLimit;
	private String letter;
	private String password;
	
	public EssentialServices(String cid, String cname, String fname, String lname, String sType, String reason,
			String address, String email, int fLimit, String letter, String password) {

		this.cid = cid;
		this.cname = cname;
		this.fname = fname;
		this.lname = lname;
		this.sType = sType;
		this.reason = reason;
		this.address = address;
		this.email = email;
		this.fLimit = fLimit;
		this.letter = letter;
		this.password = password;
	}

	public String getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getsType() {
		return sType;
	}

	public String getReason() {
		return reason;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getfLimit() {
		return fLimit;
	}

	public String getLetter() {
		return letter;
	}

	public String getPassword() {
		return password;
	}

	
	
	
}
