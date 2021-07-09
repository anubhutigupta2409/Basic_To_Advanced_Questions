// Java program for the above approach
import java.io.*;
import java.util.*;

class MinimumRemovalsFromArrayToMakeMaxMinusMinLessThanEqualToK_3
{

	// To sort the array and return the answer
	static int removals(int arr[], int n, int k)
	{
		Arrays.sort(arr);

		// fill all stated with -1
		// when only one element
		int dp[] = new int[n];
      	//where dp[i] denotes the min no. on it's left
      	//such that difference is less than k

      	Arrays.fill(dp,-1);

      	dp[0] = 0;//base case
      	int ans = n-1;

      	int i,j;

      	for(i=1;i<n;i++)
        {
          	dp[i] = i;
          	j=dp[i-1];//to the left

          	while(i!=j && arr[i] - arr[j] > k)
				j++;

          	dp[i] = Math.min(dp[i],j);
          	ans = Math.min(ans, n-(i-j+1));
         }

      	return ans;
	}

	// Driver code
	public static void main(String[] args)
	{
		int a[] = { 1, 3, 4, 9, 10, 11, 12, 17, 20 };
		int n = a.length;
		int k = 4;
		System.out.print(removals(a, n, k));
	}
}

/*
Time Complexity --> O(n) <-- discarding the complexity of sorting the array
*/
