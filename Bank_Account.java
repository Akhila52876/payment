package com.payment;

public class Bank_Account {

	private int Bank_Account_Id;
	private User user;
	private String Account_number;
	private String IFSC_code;
	private String Bank_name;
	private String Branch;
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

	public void setBank_Account_Id(int bank_Account_Id) {
		Bank_Account_Id = bank_Account_Id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccount_number() {
		return Account_number;
	}

	public void setAccount_number(String account_number) {
		Account_number = account_number;
	}

	public String getIFSC_code() {
		return IFSC_code;
	}

	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}

	public String getBank_name() {
		return Bank_name;
	}

	public void setBank_name(String bank_name) {
		Bank_name = bank_name;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public Account_Status getAccount_status() {
		return account_status;
	}

	public void setAccount_status(Account_Status account_status) {
		this.account_status = account_status;
	}
	
}
