//to find the nth prime no. after x
//using the most optimised algorithm for this -
//Sieve of Eratosthenes

import java.util.*;

public class NthPrimeNoAfterX
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n and x respectively-");
		int n= sc.nextInt();
		int x= sc.nextInt();
		//to update each number below or equal to n
		boolean isPrime[] = new boolean[n+1];
		for(int i=x;i<=n;i++)
			isPrime[i] = true; // each updated as true
		// to find a factor of a partcular no. -
		// p<=sqrt(n) SBS
		// = p*p<= n
		for(int p = x; p*p<=n ; p++)
		{	if(isPrime[p]== true)
			{	//all the multiples of the above no. are not prime
				for(int i = p*2 ; i<=n ; i+=p)
					isPrime[i]=false;
			}
		}

		System.out.println("All the prime nos. after x till n are-");
		for(int i= x; i<=n ; i++)
		{if(isPrime[i]==true)
			System.out.print(i + " ");
		}

	}
}

