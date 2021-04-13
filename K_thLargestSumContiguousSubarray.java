/*
Given an array of integers. Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
Examples:


Input: a[] = {20, -5, -1}
         k = 3
Output: 14
Explanation: All sum of contiguous
subarrays are (20, 15, 14, -5, -6, -1)
so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40}
         k = 6
Output: -10
Explanation: The 6th largest sum among
sum of all contiguous subarrays is -10.
*/

/*
Approach-->

1.Store the pre-sums of the elements of the array in an array (means sum[0] has sum of first 0 elements, and sum[3] has sum of
first 3 elements of the array).
2.for calculating the sum of a sub-array from i to j it can be calculated like ==>> sum[j] - sum[i-1]
3.now keep on storing the sums in a minHeap(priority queue) till k elements
4.now for further sums check if they are greater than the root of our minHeap
	4.a) if yes then remove the top and add it
	4.b) else let it be


Time Compexity --> O(n^2 log (k))
*/

import java.util.*;

public class K_thLargestSumContiguousSubarray
{
	public static int kThLargestSum(int arr[], int k)
	{
		int sum[] = new int[arr.length + 1];

		sum[0] = 0;
		sum[1] = arr[0];

		//pre-sums
		for(int i=2;i<=arr.length;i++)
			sum[i] = sum[i-1] + arr[i-1];

		//minHeap
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();

		for(int i=1;i<=arr.length;i++)
		{
			for(int j=i;j<=arr.length;j++)
			{
				int x = sum[j] - sum[i-1];

				if(p.size() < k)
					p.add(x);

				else
				{
					if(p.peek() < x)
					{
						p.poll();
						p.add(x);
					}
				}
			}
		}

		return p.poll();
	}

	public static void main(String args[])
	{
		int arr[] = {10, -10, 20, -40} , k=6;
		System.out.println("Kth largest sum out of all possible contiguous arrays is--> "+kThLargestSum(arr,k));
	}
}