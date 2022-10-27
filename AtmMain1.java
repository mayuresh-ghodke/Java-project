package my_atminterface_pack;

import java.util.Scanner;

public class AtmMain1{
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		AtmDemo atm_demo=new AtmDemo();

		do{
			System.out.println(" ");
			System.out.println();  
			System.out.println("------ATM Interface-------");
			
			System.out.println("  1.Balance Enquiry");
			System.out.println("  2.Withdraw Balance");
			System.out.println("  3.Deposit Money4");
			System.out.println("  4.Create Account");
			
			System.out.println("--------------------------");
			
			System.out.println("Enter Your Choice : ");
			int ch=sc.nextInt();
			
			switch(ch){
				case 1://for balance enquiry
					System.out.println("---Balance Enquiry--------");
					atm_demo.login();
					atm_demo.balance_enquiry();	
					break;
				case 2:
					System.out.println("---Withdraw Balance------");
					atm_demo.login();
					atm_demo.withdraw_balance();
					break;
				case 3:
					System.out.println("---Deposit-------");
					atm_demo.login();
					//atm_demo.deposit_money();
					break;
				case 4:
					System.out.println("---Create Account-------");
					atm_demo.create_account();
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}while(true);
			
	}
		
}

//
//try{
//	Class.forName("com.mysql.cj.jdbc.Driver");//Load the Driver
//	System.out.println("Driver Loaded");
//	
//	//Establish the connection
//	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
//	
//	System.out.println("Connectin Established");
//	
//	PreparedStatement ps=con.prepareStatement("insert into atm_info values(?,?,?)");
//	ps.setString(1, AtmDemo.usrname);
//	ps.setInt(2, AtmDemo.newpin);
//	ps.setInt(3,AtmDemo.newpass);
//	
//	int i=ps.executeUpdate();
//	
//	System.out.println("Value : "+i);
//	
//	con.close();//Close the Connection
//}
//catch(Exception e){
//	System.out.println("Error "+e);
//}
//
