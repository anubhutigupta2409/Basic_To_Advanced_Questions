//reversing an array without using another temporary array
/*
1 2 3 4 5 6	Change- 5 -> 0
6 5 4 3 2 1		4 -> 1
			3 -> 2
0 1 2 3 4 5		2 -> 3
			1 -> 4
			0 -> 5 (i -> n-1-i)
*/

import java.util.*;

public class ReverseArray
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int a[]= new int[5], i, temp;
		System.out.println("Enter the contents of array-");
		for(i=0;i<5;i++)
			a[i]=sc.nextInt();
		for(i=0;i<5/2;i++)
		{
			temp = a[i];
			a[i] = a[4-i];
			a[4-i] = temp;

		}
		System.out.println("Reversed Array-");
		for(i=0;i<5;i++)
			System.out.print(a[i]+" ");
	}
}
