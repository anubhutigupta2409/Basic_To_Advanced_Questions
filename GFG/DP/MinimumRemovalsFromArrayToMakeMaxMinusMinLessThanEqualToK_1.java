/*
Minimum removals from array to make max – min <= K

Given N integers and K, find the minimum number of elements that should be removed, such that Amax-Amin<=K. After the removal of elements, Amax and Amin is considered among the remaining elements.

Examples:

Input : a[] = {1, 3, 4, 9, 10, 11, 12, 17, 20}
          k = 4
Output : 5
Explanation: Remove 1, 3, 4 from beginning
and 17, 20 from the end.

Input : a[] = {1, 5, 6, 2, 8}  K=2
Output : 3
Explanation: There are multiple ways to
remove elements in this case.
One among them is to remove 5, 6, 8.
The other is to remove 1, 2, 5

*/

// Java program to find minimum removals
// to make max-min <= K
import java.util.Arrays;

class MinimumRemovalsFromArrayToMakeMaxMinusMinLessThanEqualToK_1
{
	static int MAX=100;
	static int dp[][]=new int[MAX][MAX];

	// function to check all possible combinations
	// of removal and return the minimum one
	static int countRemovals(int a[], int i, int j, int k)
	{
		//base case
      	if(i>=j)
          	return 0;
      	//if already less then no removal required
      	if(a[j]-a[i]<=k)
          	return 0;
      	if(dp[i][j]!=-1)
          	return dp[i][j];

      	//if (a[j]-a[i]>k)
      	int max = countRemovals(a,i,j-1,k);//remove max
      	int min = countRemovals(a,i+1,j,k);//remove min

      	dp[i][j] = 1 + Math.min(max,min);

      	return dp[i][j];
	}

	// To sort the array and return the answer
	static int removals(int a[], int n, int k)
	{
		// sort the array
		Arrays.sort(a);

		// fill all stated with -1
		// when only one element
		for(int[] rows:dp)
		Arrays.fill(rows,-1);
		if (n == 1)
			return 0;
		else
			return countRemovals(a, 0, n - 1, k);
	}

	// Driver code
	public static void main (String[] args)
	{
		int a[] = { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
		int n = a.length;
		int k = 4;
		System.out.print(removals(a, n, k));
	}
}

/*
Time Complexity -- O(n^2)
Space Complexity -- O(n^2)
*/