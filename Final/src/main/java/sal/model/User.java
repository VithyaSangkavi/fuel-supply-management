package sal.model;

public class User {
	private int id;
	private String date;
	private String amount;
	private String reason;
	
	
	public User(int id, String date, String amount, String reason) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.reason = reason;
	}
	
	
	public User(String date, String amount, String reason) {
		super();
		this.date = date;
		this.amount = amount;
		this.reason = reason;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
