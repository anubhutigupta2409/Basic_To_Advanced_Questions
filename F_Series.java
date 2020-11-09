//to find the Nth term of fibonacci series
/*
Series-
0 1 1 2 3 5 8 13 21......
Algorithm to be followed-
a=0				a=b
b=1				b=c
c=a+b
*/

import java.util.*;

public class F_Series
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value of n-");
		int n= sc.nextInt();
		int a=0, b=1, c;
		if(n<0)
			System.out.println("Invalid input");
		else
		{
		if(n==0)
			System.out.println("No element");
		else if(n==1)
			System.out.println("Series-"+a);
		else if(n==2)
			System.out.println("Series-"+a+" "+b);
		else
		{
			System.out.print("Series-"+a+" "+b+" ");
			for(int i=1;i<=n;i++)
			{
				c=a+b;
				a=b;
				b=c;
				System.out.print(c+" ");
			}
		}

		}

	}
}