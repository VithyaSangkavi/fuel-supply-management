package com.user;

public class User {

	private String userID;
	private String firstName;
	private String lastName;
	private String password;
	private String NIC;
	private String OTP;
	private String email;
	private String address;
	
	public User(String userID, String firstName, String lastName, String password, String nIC, String oTP, String email,
			String address) {
	
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		NIC = nIC;
		OTP = oTP;
		this.email = email;
		this.address = address;
	}

	public String getUserID() {
		return userID;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}


	public String getNIC() {
		return NIC;
	}

	public String getOTP() {
		return OTP;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	
	
	
}