package com.employee;

public class Employee {
private int attendanceID;
private String totalOT;
private String totalLeave;
private String month;
private String totalDaysWorked;
public Employee(int attendanceid, String totalOT, String totalLeave, String month, String totalDaysWorked) {
	
	this.attendanceID = attendanceid;
	this.totalOT = totalOT;
	this.totalLeave = totalLeave;
	this.month = month;
	this.totalDaysWorked = totalDaysWorked;
}
public int getId() {
	return attendanceID;
}
public String getTotalOT() {
	return totalOT;
}
public String getTotalLeave() {
	return totalLeave;
}
public String getMonth() {
	return month;
}
public String getTotalDaysWorked() {
	return totalDaysWorked;
}

}
