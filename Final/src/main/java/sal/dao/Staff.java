package sal.dao;



public class Staff {
	private String staffID;
	private String firstName;
	private String lastName;
	private String NIC;
	private String address;
	private String email;
	private String accNo;
	private String password;
	private String staffType;
	private int contactYears;
	private Double basicSalary;
	private Double ot;
	
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNIC() {
		return NIC;
	}
	public void setNIC(String NIC) {
		this.NIC = NIC;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public int getContactYears() {
		return contactYears;
	}
	public void setContactYears(int contactYears) {
		this.contactYears = contactYears;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getOt() {
		return ot;
	}
	public void setOt(double ot) {
		this.ot = ot;
	}
}
