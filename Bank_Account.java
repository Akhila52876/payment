package com.payment;

public class Bank_Account  {

final	private int Bank_Account_Id;
final private User user;
	final private String Account_number;
	final private String IFSC_code;
	final private String Bank_name;
	final private String Branch;
	private Account_Status account_status;
	
	public Bank_Account(int bank_Account_Id, User user, String account_number, String iFSC_code, String bank_name,
			String branch, Account_Status account_status) {
		super();
		Bank_Account_Id = bank_Account_Id;
		this.user = user;
		Account_number = account_number;
		IFSC_code = iFSC_code;
		Bank_name = bank_name;
		Branch = branch;
		this.account_status = account_status;
	}

	public int getBank_Account_Id() {
		return Bank_Account_Id;
	}

	
	public User getUser() {
		return user;
	}

	
	public String getAccount_number() {
		return Account_number;
	}

	public String getIFSC_code() {
		return IFSC_code;
	}

	public String getBank_name() {
		return Bank_name;
	}

	
	public String getBranch() {
		return Branch;
	}

	
	public Account_Status getAccount_status() {
		return account_status;
	}

	public void setAccount_status(Account_Status account_status) {
		this.account_status = account_status;
	}
	public Account_Status getaccount_status() {
		return null;
	}

	public void setAccount_Status(Account_Status account_Status) {
		
		
	}
	
}
