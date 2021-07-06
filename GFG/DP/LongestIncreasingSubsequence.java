/*
Longest Increasing Subsequence
Medium
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 = N = 105
0 = A[i] = 106
*/

class LongestIncreasingSubsequence
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        //dp[] array stores the longest increasing subsequence till element i, (ith element included)

        int dp[] = new int[size];

        //smallest valid LIS is 1, which consists of just one individual element
        Arrays.fill(dp,1);

        for(int i=1;i<size;i++)
        {
            //check if any elements behind the ith element is smaller to it
            //if yes then store the answer as max of dp[j]+1 and dp[i]
            for(int j=0;j<i;j++)
            {
                if(a[j]<a[i])
                    dp[i] = Math.max(dp[i] , dp[j]+1);
            }
        }

        //now return the max valid LIS
        int ans = Integer.MIN_VALUE;

        for(int x : dp)
            ans = Math.max(ans, x);

        return ans;

    }
}

/*
Time Complexity --> O(n^2)
Space Complexity --> O(n)
*/