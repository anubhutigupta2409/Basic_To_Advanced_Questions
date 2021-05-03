import java.util.*;

public class NearestSmallerToLeft
{
	public static int[] nearestSmallerToLeft(int arr[])
	{
		int n = arr.length;
		int ans[] = new int[n];

		Stack<Integer> stk = new Stack<>();

		for(int i=0;i<n;i++)
		{
			while(!stk.empty() && stk.peek() >= arr[i])
				stk.pop();

			if(stk.empty())
				ans[i] = -1;

			else if(stk.peek() < arr[i])
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

		print(nearestSmallerToLeft(arr));
	}
}