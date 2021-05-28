/*

Chocolate Distribution Problem

Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet
can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such
that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is
minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between
maximum chocolates and minimum chocolates
is 9 - 3 = 6 by choosing following M packets :
{3, 4, 9, 7, 9}.
Example 2:

Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between
maximum chocolates and minimum chocolates
is 4 - 2 = 2 by choosing following M packets :
{3, 2, 4}.
Your Task:
You don't need to take any input or print anything. Your task is to complete the function findMinDiff() which takes array A[ ], N
and M as input parameters and returns the minimum possible difference between maximum number of chocolates given to a student and
minimum number of chocolates given to a student.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 = T = 100
1 = N = 105
1 = Ai = 109
1 = M = N
*/

class ChocolateDistributionProblem
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        long ans= Long.MAX_VALUE;


        if(n<m)
            return -1;
        else if(n==0 || m==0)
            return 0;

        Collections.sort(a);

        int N=a.size();
        int M= (int)m;
        if(n==m)
            return a.get(N-1)-a.get(0);


        long diff;//difference for the current subarray

        // Find the subarray of size m
        // such that difference between
        // last (maximum in case of
        // sorted) and first (minimum in
        // case of sorted) elements of
        // subarray is minimum.
        for(int i=0;i+M-1<n;i++)
        {
            diff=a.get(i+M-1)-a.get(i);//last - first// max-min
            ans= (long)Math.min(diff,ans);
        }

        return ans;
    }
}