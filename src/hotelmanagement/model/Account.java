package hotelmanagement.model;

public class Account {
	private int accountId;
	private String accountName;
	private String accountPass;
	private String accountDisplay;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountPass() {
		return accountPass;
	}
	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}
	public String getAccountDisplay() {
		return accountDisplay;
	}
	public void setAccountDisplay(String accountDisplay) {
		this.accountDisplay = accountDisplay;
	}
}