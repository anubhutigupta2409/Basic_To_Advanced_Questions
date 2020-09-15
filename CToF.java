//to convert celsius to fahrenheit and vice versa

import java.util.*;

public class CToF
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Press 1 to convert celsius to fahrenheit");
		System.out.println("2. Press 2 to convert fahrenheit to celsius");
		int c= sc.nextInt();
		if(!(c==2 || c==1))
			System.out.println("Wrong Choice");
		else
		{
		System.out.println("Enter the temperature value-");
		float i_p= sc.nextFloat();
		float result;
		if(c==1)
		{
			result= (float)(((i_p)*(9.0/5.0)) +32.0);
			System.out.println("Converted Temperature-"+result);
		}
		else if(c==2)
		{
			result= (float)((i_p-32)*(5.0/9.0));
			System.out.println("Converted Temperature-"+result);
		}

		}
	}
}