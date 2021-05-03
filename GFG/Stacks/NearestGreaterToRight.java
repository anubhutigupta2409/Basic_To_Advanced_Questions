/*
Next greater element in same order as input
Difficulty Level : Medium

Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1. The next greater elements should be printed in same order as input array.

Examples:

Input : arr[] = [4, 5, 2, 25}
Output : 5 25 25 -1

Input : arr[] = [4, 5, 2, 25, 10}
Output : 5 25 25 -1 -1
*/

/*
Approach-->
brute force solution-->

for(int i=0;i<n-1;i++)
	for(int j=i+1;j<n;j++)

j dependent on i, therefore, use of stack
since we want the nearest greater to right, we traverse the array from right since we want that the nearest greater to right remains
at stack's top.

if(at any point stack is empty means no nge therefore push -1 for the answer, if stk.top() > arr[i], push stack's top, else
keep on popping till either the stack becomes empty, or stack's top > arr[i])

at the end push the ith element into the stack

*/
import java.util.*;

public class NearestGreaterToRight
{
	public static int[] NGE(int arr[])
	{
		int n = arr.length;
		int ans[] = new int[n];

		Stack<Integer> stk = new Stack<>();

		//starting from right hand side
		for(int i=n-1;i>=0;i--)
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

		print(NGE(arr));
	}
}