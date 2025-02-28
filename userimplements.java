package com.payment;

import java.util.ArrayList;
import java.util.Scanner;

public class userimplements implements Useractionsinter {
ArrayList<User> u=new ArrayList<>();
Scanner sc=new Scanner(System.in);
	public void login() {
		System.out.println("Enter username:");
		String s1=sc.nextLine();
		sc.nextLine();
		System.out.println("Enter password:");
		String s2=sc.nextLine();
		display();
		
	}

	public void register() {
		System.out.println("Enter username:");
		String s1=sc.nextLine();		
		System.out.println("Enter Firstname:");
		String s2=sc.nextLine();
		System.out.println("Enter Lastname:");
		String s3=sc.nextLine();
		System.out.println("Enter email:");
		String s4=sc.nextLine();
		System.out.println("Enter phonenumber:");
		int s6=sc.nextInt();
		System.out.println("Enter password:");
		String s7=sc.next();
		User u1=new User( s1,s2,s3,s4,s6,s7);
		u.add(u1);
		System.out.println("registration successfully done");
		login();
	}
	
public void display() {
	if(u.isEmpty()){
		System.out.println("user is not registered");
	}
	else {
		for(User user:u) {
			System.out.println("user is registered :"+user);
		}
	}
}
}
		

