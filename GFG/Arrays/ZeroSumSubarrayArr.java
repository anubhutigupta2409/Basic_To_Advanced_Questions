/*
Given an array a[] of N positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains N space separated integers forming the array.

Output:
Print "Yes" ( without quotes) if there exist a subarray of size at least one with sum equal to 0 or else print "No" ( without quotes).

Constraints:
1 <= T <= 100
1 <= N <= 104
-105 <= a[i] <= 105

Example:
Input:
2
5
4 2 -3 1 6
5
4 2 0 1 6

Output:
Yes
Yes
*/

import java.util.*;

public class ZeroSumSubarrayArr
{
	public static void main (String[] args) {
			//code
			Scanner sc=new Scanner(System.in);
			int t= sc.nextInt();
			while(t-->0)
			{
			    int n=sc.nextInt();
			    if(n<0)
			        System.out.println("No");
			    else
			    {
			    int a[]=new int[n];
			    for(int i=0;i<n;i++)
			        a[i]=sc.nextInt();
			    boolean found =false;
			    for(int i=0;i<n;i++)
			    {
			        int sum=0;
			        for(int j=i;j<n;j++)
			        {
			            sum+=a[j];
			            if(sum==0)
			            {
			                found=true;
			                break;
			            }
			            
			        }
			        if(found)
		               break;
			    }
			    if(found)
			        System.out.println("Yes");
			    else
			        System.out.println("No");
			    }
			}
	}
}