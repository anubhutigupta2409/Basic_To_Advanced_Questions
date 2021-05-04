/*
The Stock Span Problem
Difficulty Level : Medium

The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate
span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day,
for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding
7 days are {1, 1, 1, 2, 1, 4, 6}
*/

/*
Approach-->
{100,80,60,70,60,75,85} <-- array
  0 , 1, 2, 3, 4, 5, 6  <-- index --> (1)
 -1 , 0, 1, 1, 3, 1, 0  <-- indices of nearest greater to left elements --> (2)
  1 , 1 ,1, 2, 1, 4, 6  <-- required output

  observation --> required output = (1) - (2)
*/
import java.util.*;

class Pair
{
	int index;//storing index of the nearest greater to left
	int element;//storing the element that is the value of the nearest greater to left

	public Pair(int index, int element)
	{
		this.index = index;
		this.element = element;
	}
}
public class StockSpanProblem
{
	public static int[] stockSpan(int arr[])
	{
		int n = arr.length ;
		int ans[] = new int[n];

		Stack<Pair> stk = new Stack<>();

		//traversing the array-->
		for(int i=0;i<n;i++)
		{
			//pop useless elements
			while( !stk.empty() && stk.peek().element <= arr[i])
				stk.pop();

			if(stk.empty())
				ans[i] = -1;//no nge

			else if(stk.peek().element > arr[i])
				ans[i] = stk.peek().index;//store index

			stk.push(new Pair(i,arr[i]));
		}

		//final output array == (element.index - nge.index)
		for(int i=0;i<n;i++)
			ans[i] = i-ans[i];

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
		int arr[] = {100, 80, 60, 70, 60, 75, 85};
		print(stockSpan(arr));
	}
}