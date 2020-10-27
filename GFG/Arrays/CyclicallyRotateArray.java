/*
Given an array, cyclically rotate an array by one.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then following line contains 'n' integers forming the array. 

Output:
Output the cyclically rotated array by one.

Constraints:
1<=T<=1000
1<=N<=1000
0<=a[i]<=1000

Example:
Input:
2
5
1 2 3 4 5
8
9 8 7 6 4 2 1 3

Output:
5 1 2 3 4
3 9 8 7 6 4 2 1
*/

/*
approach-		3->4
			2->3
1 2 3 4 5//actual	1->2
5 1 2 3 4//rotated	0->1//using a loop (a[i]=a[i-1])
			
0 1 2 3 4//indices	5->0//store in another value and manually transefer
*/

import java.util.*;

public class CyclicallyRotateArray
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    int x=a[n-1];
		    for(int i=n-1;i>0;i--)
		        a[i]=a[i-1];
				  
		    a[0]=x;
		    for(int i=0;i<n;i++)
		        System.out.print(a[i]+" ");
				  
		    System.out.println();
				    
				    
		}
	}
}