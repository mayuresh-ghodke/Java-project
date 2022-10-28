package my_atminterface_pack;

import java.io.IOException;
import java.util.Scanner;

public class AtmMain{
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		AtmDemo atm_demo=new AtmDemo();

		do{
			System.out.println(" ");
			System.out.println();  
			System.out.println("------ATM Interface-------");
			
			System.out.println("  1.Balance Enquiry");
			System.out.println("  2.Withdraw Balance");
			System.out.println("  3.Deposit Money");
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
					System.out.println("---Withdraw Balance--------");
					atm_demo.login();
					atm_demo.withdraw_balance();
					break;
				case 3:
					System.out.println("---Deposit--------");
					atm_demo.login();
					atm_demo.deposit_money();
					break;
				case 4:
					System.out.println("---Create Account--------");
					atm_demo.create_account();
					break;
				default:
					System.out.println("Invalid Choice\nYour choice must be from above numbers");
			}
		}while(true);	
	}		
}