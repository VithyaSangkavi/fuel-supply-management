package com.notice;

public class NoticeReport {
	private int num_notices;
	private String month;
	private int year;
	
	public NoticeReport(int num_notices, String month, int year) {
		
		this.num_notices = num_notices;
		this.month = month;
		this.year = year;
	}

	public int getNum_notices() {
		return num_notices;
	}

	public String getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setNum_notices(int num_notices) {
		this.num_notices = num_notices;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
