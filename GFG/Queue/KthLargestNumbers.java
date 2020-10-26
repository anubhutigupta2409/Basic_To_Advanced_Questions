/*
Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.

Example 1:

Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.
Example 2:

Input:
N = 7, K = 3
Arr[] = {1, 23, 12, 9, 30, 2, 50}
Output: 50 30 23
Explanation: 3 Largest element in the
array are 50, 30 and 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function kLargest() which takes the array of
integers arr, n and k as parameters and returns an array of integers denoting the answer.
The array should be in decreasing order.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K*logK)

Constraints:
1 = K = N = 105
1 = Arr[i] = 106
*/

import java.util.*;

public class KthLargestNumbers
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();//testcases
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int k=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();

			PriorityQueue<Integer> pq=new PriorityQueue<>();
			for(int i=0;i<n;i++)
			{
			    if(i<k)
			        pq.add(a[i]);//for the starting k elements we add tham without any checking

			    //if the element at the highest priority is smaller than our current element
			    //remove it
			    //and add our larger element
			    else
			    {
			        if(pq.peek()<a[i])
			        {
			            pq.poll();
			            pq.add(a[i]);
			        }

			     }
        	}
        	//as we have to print the answer in descending order
        	ArrayList<Integer> ans= new ArrayList<>(pq);
		    Collections.sort(ans,Collections.reverseOrder());

		    for(int x:ans)
		    	System.out.print(x+" ");

			System.out.println();//new line

		}
	}
}
