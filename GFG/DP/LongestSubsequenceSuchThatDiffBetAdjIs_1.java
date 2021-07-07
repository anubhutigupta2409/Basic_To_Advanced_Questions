/*
Longest subsequence-1
Easy
Given an array A[] of size N, find the longest subsequence such that difference between adjacent elements is one.


Example 1:

Input: N = 7
A[] = {10, 9, 4, 5, 4, 8, 6}
Output: 3
Explaination: The three possible subsequences
{10, 9, 8} , {4, 5, 4} and {4, 5, 6}.

Example 2:

Input: N = 5
A[] = {1, 2, 3, 4, 5}
Output: 5
Explaination: All the elements can be
included in the subsequence.

Your Task:
You do not need to read input. Your task is to complete the function longestSubseq() which takes N and A[] as input parameters and returns the length of the longest such subsequence.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 = N = 103
1 = A[i] = 103
*/
class LongestSubsequenceSuchThatDiffBetAdjIs_1{
    static int longestSubsequence(int n, int a[])
    {
        // code here
        //dp array
        int dp[] = new int[n];

        Arrays.fill(dp,1);//individual subsequence

        //variation of longest increasing subsequence
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(Math.abs(a[i]-a[j])==1)
                    dp[i] = Math.max(dp[i],1+dp[j]);
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int x: dp)
            ans = Math.max(x,ans);

        return ans;

    }
}