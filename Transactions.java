package com.payment;

import java.security.Timestamp;

public class Transactions {

	private int transaction_id;
	private Timestamp transaction_time;
	private int source_id;
	private int target_id;
	private Source_Type source_type;
	private Source_Type destination_type;
	private double Transaction_Amount;
	private int user_id;
    private User users;
    
	public Transactions(int transaction_id, Timestamp transaction_time, int source_id, int target_id,
			Source_Type source_type, Source_Type destination_type, double transaction_Amount, int user_id, User users) {
		super();
		this.transaction_id = transaction_id;
		this.transaction_time = transaction_time;
		this.source_id = source_id;
		this.target_id = target_id;
		this.source_type = source_type;
		this.destination_type = destination_type;
		Transaction_Amount = transaction_Amount;
		this.user_id = user_id;
		this.users = users;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Timestamp getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(Timestamp transaction_time) {
		this.transaction_time = transaction_time;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public int getTarget_id() {
		return target_id;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
	public Source_Type getSource_type() {
		return source_type;
	}
	public void setSource_type(Source_Type source_type) {
		this.source_type = source_type;
	}
	public Source_Type getDestination_type() {
		return destination_type;
	}
	public void setDestination_type(Source_Type destination_type) {
		this.destination_type = destination_type;
	}
	public double getTransaction_Amount() {
		return Transaction_Amount;
	}
	public void setTransaction_Amount(double transaction_Amount) {
		Transaction_Amount = transaction_Amount;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
    
	
}
