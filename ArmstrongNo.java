//armstrong number or not
//if the sum of individual digits of a number raised to
//power equal to it's number of digits is itself only

import java.util.*;

public class ArmstrongNo
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the number to be checked-");
		long n= sc.nextLong();
		long temp= n;
		int count=0;
		while(temp!=0)
		{
			temp/=10;
			count++;
		}
		long sum=0, lastDigitPower;
		temp=n;
		while(temp!=0)
		{
			lastDigitPower= (long)Math.pow((temp%10),count);
			sum+=lastDigitPower;
			temp/=10;
		}
		if(sum==n)
			System.out.println("Armstrong Number");
		else
			System.out.println("Not an Armstrong Number");
	}
}