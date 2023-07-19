package VMS.Model;

import java.sql.Date;

public class VMS_Create {
	
	private String chassis_Number;
	private String plate_number;
	private String vtype;
	private float fuelLimit;
	private String date;
	private String fuelType;
	private float RemainFuel;
	private String UserID;
	

	public String getUserID() {
		return UserID;
	}
	public void setID(String iD) {
		UserID = iD;
	}
	public float getRemainFuel() {
		return RemainFuel;
	}
	public void setRemainFuel(float remainFuel) {
		RemainFuel = remainFuel;
	}
	public String getChassis_Number() {
		return chassis_Number;
	}
	public void setChassis_Number(String chassis_Number) {
		this.chassis_Number = chassis_Number;
	}
	public String getPlate_number() {
		return plate_number;
	}
	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public float getFuelLimit() {
		return fuelLimit;
	}
	public void setFuelLimit(float fuelLimit) {
		this.fuelLimit = fuelLimit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	

}
