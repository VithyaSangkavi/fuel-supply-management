package com.notice;



public class Notice {
	private int id;
	private String title;
	private String notice_type;
	private String date;
	private String notice_desc;
	private String email;
	
	public Notice(int id, String title, String notice_type, String date, String notice_desc, String email) {

		this.id = id;
		this.title = title;
		this.notice_type = notice_type;
		this.date = date;
		this.notice_desc = notice_desc;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getNotice_type() {
		return notice_type;
	}
	public String getDate() {
		return date;
	}

	public String getNotice_desc() {
		return notice_desc;
	}

	public String getEmail() {
		return email;
	}

	
}
