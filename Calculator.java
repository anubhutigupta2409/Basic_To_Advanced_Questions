// giving the output based on arithmetic operation as told by the user

import java.util.*;

public class Calculator
{
	public static void main(String args[])
	{	Scanner sc= new Scanner(System.in);
		System.out.println("Enter your expression in the following form- (a *operation* b)-");
		int a= sc.nextInt();
		String escape_String = sc.nextLine();
		char op= sc.next().charAt(0);
		int b= sc.nextInt();
		switch(op)
		{
			case '+' :
				System.out.println("Result="+(a+b));
				break;
			case '-' :
				System.out.println("Result="+(a-b));
				break;
			case '*' :
				System.out.println("Result="+(a*b));
				break;
			case '/' :
				System.out.println("Result="+(a/b));
				break;
			default :
				System.out.println("Invalid Input");
		}
	}
}