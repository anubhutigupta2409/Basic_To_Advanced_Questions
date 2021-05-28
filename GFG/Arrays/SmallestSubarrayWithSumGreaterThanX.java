/*

Smallest subarray with sum greater than x

Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.

Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).

Example 1:

Input:
A[] = {1, 4, 45, 6, 0, 19}
x  =  51
Output: 3
Explanation:
Minimum length subarray is
{4, 45, 6}

Example 2:
Input:
A[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Explanation:
Minimum length subarray is {10}


Your Task:
You don't need to read input or print anything. Your task is to complete the function sb() which takes the array A[], its size N
and an integer X as inputs and returns the required ouput.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 = N, x = 105
1 = A[] = 104
*/
class SmallestSubarrayWithSumGreaterThanX{

    public static long sb(long a[], long n, long x) {
        // Your code goes here
        //maximum case for our length
        long minLen=n+1;

        long currSum=0;

        int N=a.length;

        int start=0, end =0;

        while(end<N)
        {
            //keep on adding till we reach the given sum
            while(currSum<=x && end<N)
                currSum+=a[end++];

            //if we exceed, remove the starting elements, and update the
            //minimum length
            while(currSum>x && start<N)
            {
                minLen= Math.min(minLen,end-start);
                currSum-=a[start++];
            }
        }
        return minLen;
    }
}

