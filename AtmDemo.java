package my_atminterface_pack;

import java.util.*;
import java.io.*;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class AtmDemo{
	
	int balance=1000;
	Scanner sc=new Scanner(System.in);
	static String usrname;
	static int newpin;
	static int newpass;
	static String gen;
	static int deposit_amt;
	
	void login(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			Statement st=con.createStatement();
			//System.out.println("Statement Created");
			
			System.out.println("Enter Your Pin : ");
			int usrpin=sc.nextInt();
			System.out.println("Enter Password : ");
			int usrpass=sc.nextInt();
			
			ResultSet rs=st.executeQuery("select * from atm_info");
			
			while(rs.next()){
				
				try {
					if(usrpin==rs.getInt(1) && (usrpass==rs.getInt(4))){
						System.out.println("Welcome back "+rs.getString(2));
					}
				}
				catch(Exception error) {
					System.out.println("Error: "+error);
				}			
			}
			con.close();
		} 
		catch(Exception e1) {
			System.out.println("Error : "+e1);
		}	
	}	
	
	
	
	int balance_enquiry() {
		balance=1000;//select balance from table_name;
		
		System.out.println("Your Current Balance is : "+"Rs."+balance);
		System.out.println("-----------------------------");
		return 0;
		
	}
	
	void withdraw_balance() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			System.out.println("Connectin Established");
			
			System.out.print("Enter Amount You Want To Withdraw : Rs.");
			int withdraw_amt=sc.nextInt();
			
			if(withdraw_amt>0)
			{
				if(withdraw_amt<=balance) 
				{
					PreparedStatement ps=con.prepareStatement("insert into atm_info values(?)");
					
					ps.setInt(1, withdraw_amt);
					int i=ps.executeUpdate();
					
					System.out.println("Value : "+i);
					
					con.close();//Close the Connection
					System.out.println("Congratulations! Your Withdraw Transaction is Successfull");
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
		catch(Exception e)
		{
			System.out.println("Error : "+e);
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
	
	/*void deposit_money() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
			//System.out.println("Driver Loaded");
			
			//Establish the connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
			//System.out.println("Connectin Established");
			
			System.out.print("Enter Amount You Want To Deposit : Rs.");
			deposit_amt=sc.nextInt();
			
			PreparedStatement ps=con.prepareStatement("insert into atm_info values(?)");
			
			ps.setInt(5, AtmDemo.deposit_amt);
			
			int i=ps.executeUpdate();
			
			System.out.println("Value : "+i);
			
			con.close();//Close the Connection
		}
		catch(Exception de) {
			System.out.println("Error : "+de);
		}
	}*/
	
	
}

