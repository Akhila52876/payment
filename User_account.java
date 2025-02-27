package com.payment;

import java.sql.Date;

public class User_account {

	private int Account_Id;
	private  Date Open_Date;
	private int Current_Account_balance;
	private int Linked_Bank_Account_counts;
	private User user;
	private int Pin_number;
	
	public User_account(int account_Id, Date open_Date, int current_Account_balance, int linked_Bank_Account_counts,
			User user, int pin_number) {
		super();
		Account_Id = account_Id;
		Open_Date = open_Date;
		Current_Account_balance = current_Account_balance;
		Linked_Bank_Account_counts = linked_Bank_Account_counts;
		this.user = user;
		Pin_number = pin_number;
	}	
	
	public int getAccount_Id() {
		return Account_Id;
	}
	public void setAccount_Id(int account_Id) {
		Account_Id = account_Id;
	}
	public Date getOpen_Date() {
		return Open_Date;
	}
	public void setOpen_Date(Date open_Date) {
		Open_Date = open_Date;
	}
	public int getCurrent_Account_balance() {
		return Current_Account_balance;
	}
	public void setCurrent_Account_balance(int current_Account_balance) {
		Current_Account_balance = current_Account_balance;
	}
	public int getLinked_Bank_Account_counts() {
		return Linked_Bank_Account_counts;
	}
	public void setLinked_Bank_Account_counts(int linked_Bank_Account_counts) {
		Linked_Bank_Account_counts = linked_Bank_Account_counts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPin_number() {
		return Pin_number;
	}
	public void setPin_number(int pin_number) {
		Pin_number = pin_number;
	}
	
}
