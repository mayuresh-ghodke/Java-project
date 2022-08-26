package firstpack;
import java.util.*;

public class Calculator {
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		
		int size;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("*******CALCULATOR*******");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("1. Addition (+)");
		System.out.println("2. Subtraction (-)");
		System.out.println("3. Multiplication (*)");
		System.out.println("4. Division (/)");
		System.out.println("5. Modulo (%)");
		System.out.println("-------------------------------------");
		System.out.println(" ");
		System.out.print("Please Enter Your Choice : ");
		int ch=sc.nextInt();
		System.out.println("-------------------------------------");

		
		//to know the users input 
		if(ch==1) 
		{
			System.out.println("You have choosen ADDITION");
		}
		else 
			if(ch==2)
			{
				System.out.println("You have choosen SUBTRACTION");
			}
			else 
				if(ch==3) 
				{
					System.out.println("You have choosen MULTIPLICATION");
				}
				else 
					if(ch==4)
					{
						System.out.println("You have choosen DIVISION");
					}
					else 
						if(ch==5)
						{
							System.out.println("You have choosen MODULO");
						}
						
		
		//to perform the operations using switching
		switch(ch) 
		{
		
		case 1://for addition
				System.out.print("Total Numbers : ");			
				size = sc.nextInt();
				
			    int arr[] = new int [size];
			    int sum = 0;
			    
			    System.out.print("Enter the numbers : "); 
			    for(int i=0; i<size; i++)
			    {
			       
			       arr[i] = sc.nextInt();
			       sum = sum + arr[i];   
			    }
			    
			    System.out.println("Addition is : "+sum);
			    break;
			    
		case 2://for subtraction
				System.out.println("How many times : ");
				int num=sc.nextInt();
				for(int i=0;i<num;i++) 
				{
					System.out.println(" ");
					System.out.println("Enter the first number  : ");
					int first=sc.nextInt();
					System.out.println("Enter the Second number : ");
					int second=sc.nextInt();
					
					int sub=first-second;
					System.out.println("Subtraction is : "+sub);
				}
						   
				break;
		    
		case 3://for multiplication
				System.out.print("Total Numbers : ");			
				size = sc.nextInt();
				int arrmul[] = new int [size];
			    int mul = 1;
			    System.out.println("Enter the Numbers : ");
			    for(int i=0; i<size; i++)
			    {
			       arrmul[i] = sc.nextInt();
			       mul = mul * arrmul[i];
			    }
			    System.out.println("Multiplication is : "+mul);
			    break;
		    
		case 4://for division
				int div;
			    System.out.print("Enter the Numerator   : ");
			    int nume=sc.nextInt();
			    System.out.print("Enter the Denominator : ");
			    int deno=sc.nextInt();
			  //to check whether denominator is 0 or not
			    if(deno==0) {
			    	System.out.println("Cannot Divide by zero");
			    }
			    else
			    {
				    div=nume/deno;
				    
				    System.out.println("Division is : "+div);
			    }
				break;
		 
		case 5://for modulus
				int mod;
			    System.out.print("Enter the first number   : ");
			    int number=sc.nextInt();
			    System.out.println("Enter the second number  : ");
			    int second=sc.nextInt();
			    
			    mod=number%second;
			    
			    System.out.println("Modulus is : "+mod);
			    break;
			
			
		default:
				System.out.println("Invalid Choice, Please Enter Choice Between (1-5)");
				
		
		
		}
		
		
	}

}
