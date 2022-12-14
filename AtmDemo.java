package my_atminterface_pack;

import java.util.*;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class AtmDemo{
	
	Scanner sc=new Scanner(System.in);
	static String usrname;
	static int usrpin;
	static int usrpass;
	static int newpin;
	static int newpass;
	static String gen;
	static int deposit_amt;
	static int balance;
	
	void login(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			//System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			Statement st=con.createStatement();
			//System.out.println("Statement Created");
			
			System.out.println("Enter Your Pin : ");
			usrpin=sc.nextInt();
			System.out.println("Enter Password : ");
			int usrpass=sc.nextInt();
			
			ResultSet rs=st.executeQuery("select * from atm_info");
			
			while(rs.next()){
				if(usrpin==rs.getInt(1) && (usrpass==rs.getInt(4))) {
					System.out.println("Welcome back "+rs.getString(2));
				}
			}
			con.close();
		} 
		
		
		catch(Exception e1) {
			System.out.println("Error : "+e1);
		}	
	}	
	
	
	
	int balance_enquiry() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			//System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from atm_info where pin="+usrpin+";");
			//fetch results from database using condition pin = entered'usrpin' from user
			
			while(rs.next()) {
				System.out.println("Your current balance is : Rs."+rs.getInt(5));
			}
			con.close();
		}
		catch(Exception be) {
			System.out.println("Error : "+be);
		}
		return 0;
	}
	
	void withdraw_balance() {
		int bal;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			//System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from atm_info where pin="+usrpin+";");
			
			while(rs.next()) {
				bal=rs.getInt(5);
				System.out.println("Your Current balance is Rs."+bal);
				
				System.out.print("Enter Amount You Want To Withdraw : Rs.");
				int withdraw_amt=sc.nextInt();
				
				if(withdraw_amt>0)
				{
					if(withdraw_amt<=bal) 
					{
						bal = bal - withdraw_amt;
						
						PreparedStatement ps=con.prepareStatement("update atm_info set balance=? where pin="+usrpin+";");
						
						ps.setInt(1,bal);
						
						int i=ps.executeUpdate();
						System.out.println("Congratulations! Your Withdraw Transaction is successfull.");
					}
					else 
					{
						System.out.println("Insufficient Balance");
					}
				}
				else {
					System.out.println("Please Enter Valid Input");
				}
			}
			con.close();//Close the Connection
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e);
		}
	}
	
	void deposit_money() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			//System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select balance from atm_info where pin="+usrpin+";");
			
			System.out.print("Enter Amount You Want To Deposit : Rs.");
			deposit_amt=sc.nextInt();
						
			balance = balance + deposit_amt;
			
			PreparedStatement ps=con.prepareStatement("update atm_info set balance=? where pin="+usrpin+";");
			
			ps.setInt(1, AtmDemo.balance);
			
			int i=ps.executeUpdate();
			
			//System.out.println("Value : "+i);
			if(i!=1) {
				System.out.println("Something went wrong! Try again later....");
			}
			else {
				System.out.println("Your Deposit Transaction has been done successfully.");
			}
			con.close();//Close the Connection
		}
		catch(Exception de) {
			System.out.println("Error : "+de);
		}
	}

	
	void create_account() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			System.out.println("Connectin Established");
			
			System.out.println("Enter Name : ");
			usrname=sc.nextLine();
			System.out.println("Gender : ");
			gen=sc.nextLine();
			System.out.println("Create New Pin : ");
			newpin=sc.nextInt();     
			System.out.println("Create Password : ");
			newpass=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement("insert into atm_info values(?,?,?,?)");
			
			ps.setInt(1, AtmDemo.newpin);
			ps.setString(2, AtmDemo.usrname);
			ps.setString(3,AtmDemo.gen);
			ps.setInt(4,AtmDemo.newpass );
			
			int i=ps.executeUpdate();
			
			System.out.println("Value : "+i);
			
			con.close();//Close the Connection
			
			System.out.println("Hello, "+usrname+" \nCongratulations! Your account has been created successfully.");
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
		
	}
}	
	

