/*
Given an array a[] of N positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case
contains an integer n denoting the size of the array. The next line contains N space separated integers forming the array.

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

/*
Approach-
while we are traversing through the given array from left to right we store all the sums of all the subarrays in a set, then
thinking deeply we can notice that it doesnot matter how much long we go in the array ,if a subarray with sum =0 existed then
the sum of a bigger subarray will be equal to the sum of a smaller subarray we already stored. so we check if the sum already exists
in the set we return true.
--> same approach can also be thought for a sub array with sum=k and not 0 then we have to check if the current sum-k already exists
then return true;
*/

import java.util.*;

public class ZeroSumSubarraySet
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
			    Set<Integer> set= new HashSet<>();
			    int sum=0;
			    for(int ele : a)
			    {
			        set.add(sum);
			        sum+=ele;
			        if(set.contains(sum))
			        {
			            found=true;
			            break;
			        }
			    }
			    if(found)
			        System.out.println("Yes");
			    else
			        System.out.println("No");
			    }
			}
	}
}