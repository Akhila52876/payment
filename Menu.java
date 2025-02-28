package com.payment;

import java.util.Scanner;

public class Menu {
       Scanner sc=new Scanner(System.in);
       void display() {
    	      System.out.println("enter 1 for login and 2 for register");
    	         int   x=sc.nextInt();
       if(x==1) {
    	   userimplements  user=new userimplements();
    	 user.login();
       }
    	 
       else if(x==2) {
    	   userimplements user=new userimplements();
      	 user.register();
         }
       else {
    	   userimplements user=new userimplements();
        	 user.display
        	 ();
       }
       }
      
public static void main(String args[])
{
	Menu m=new Menu();
	m.display();
}
}
