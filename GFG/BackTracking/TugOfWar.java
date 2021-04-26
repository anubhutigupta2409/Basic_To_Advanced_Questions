/*
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets
is as minimum as possible. If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, then size of one
subset must be (n-1)/2 and size of other subset must be (n+1)/2.

For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. Output for this set should be
{4, 100, 1, 23, 20} and {3, 5, -3, 89, 54}. Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}. The output
subsets should be {45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}. The sums of elements in two subsets are 120 and 121
respectively.
*/

/*
Approach-->
The following solution tries every possible subset of half size. If one subset of half size is formed, the remaining elements
form the other subset. We initialize current set as empty and one by one build it. There are two possibilities for every
element, either it is part of current set, or it is part of the remaining elements (other subset). We consider both
possibilities for every element. When the size of current set becomes n/2, we check whether this solutions is better than the
best solution available so far. If it is, then we update the best solution.
*/

public class TugOfWar
{
	public static int minDiff= Integer.MAX_VALUE;

	public static void tugOfWarUtil(int arr[], int n, boolean currEle[] , boolean sol[], int noOfSelectedElements, int sum, int currSum,int currPosition)
	{
		if(currPosition==n)
			return;

		if(n/2 - noOfSelectedElements > n - currPosition)
			return;

		//not including the current element to the subset
		tugOfWarUtil(arr,n,currEle,sol,noOfSelectedElements,sum,currSum,currPosition+1);

		//adding
		noOfSelectedElements++;
		currSum += arr[currPosition];
		currEle[currPosition] = true;

		//checking if solution is made
		if(noOfSelectedElements == n/2)
		{
			//check if it's the best possible solution
			if(Math.abs(sum/2 - currSum) < minDiff)
			{
				minDiff= Math.abs(sum/2 - currSum);

				for(int i=0;i<n;i++)
					sol[i] = currEle[i];
			}
		}
		else
		{
			//recur for element was included
			tugOfWarUtil(arr,n,currEle,sol,noOfSelectedElements,sum,currSum,currPosition+1);
		}

		//backTrack
		currEle[currPosition] = false;
	}
	public static void tugOfWar(int arr[], int n)
	{
		boolean currEle[] = new boolean[n];//current situation
		//shows the situation whether an element is part of the current subset or not
		//if true then part of the current subset else part of the other subset

		boolean sol[] = new boolean[n];//final status

		int sum=0;

		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			currEle[i] = sol[i] = false;
		}

		tugOfWarUtil(arr,n,currEle,sol,0,sum,0,0);

		System.out.println("Subsets ==>");

		System.out.println("\nSubset-1 -->");
		for(int i=0;i<n;i++)
		{
			if(sol[i]==true)
				System.out.print(arr[i]+" ");
		}

		System.out.println("\nSubset-2 -->");
		for(int i=0;i<n;i++)
		{
			if(sol[i]==false)
				System.out.print(arr[i]+" ");
		}
	}

	public static void main(String args[])
	{
		 int arr[] = {23, 45, -34, 12, 0, 98,
                     -99, 4, 189, -1, 4};

         tugOfWar(arr,arr.length);
	}
}