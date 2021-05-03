/*
In case of this problem, an array is given and we have to find first greater element to the left of current element. Similalrly,
find the greater elements for each element in the array and if greater element is not available then return a default value based on the problem.

Nearest greatest element to left example
Example -
Input: [4, 5, 2, 0]
Output: [-1, -1, 5, 2]

Input: [1, 6, 4, 10, 2, 5]
Output: [-1, -1, 6, -1, 10, 10]
*/

/*
Approach-->
Same as nearest greater to right, just we start of by traversing the array from left to right.

Brute-force approach-->

for(int i=0;i<n;i++)
	for(int j=i-1;j>=0;j--)
*/

import java.util.*;

public class NearestGreaterToLeft
{
	public static int[] nearestGreaterToLeft(int arr[])
	{
		int n = arr.length;
		int ans[] = new int[n];

		Stack<Integer> stk = new Stack<>();

		for(int i=0;i<n;i++)
		{
			while(!stk.empty() && stk.peek() <= arr[i])
				stk.pop();

			if(stk.empty())
				ans[i] = -1;

			else if(stk.peek() > arr[i])
				ans[i] = stk.peek();

			stk.push(arr[i]);
		}

		return ans;
	}
	public static void print(int arr[])
	{
		System.out.println();

		for(int x : arr)
			System.out.print(x+" ");

		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {1,3,0,0,1,2,4};

		print(nearestGreaterToLeft(arr));
	}
}