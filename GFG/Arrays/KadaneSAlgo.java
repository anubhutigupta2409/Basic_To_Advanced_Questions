/*

Kadane's Algorithm
Medium
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.


Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which
is a contiguous subarray.
Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1
of element (-1)

Your Task:
You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes arr and N as
input parameters and returns the sum of subarray with maximum sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 = N = 106
-107 = A[i] = 107
*/
/*

Approach-->
1. Brute force considers all the subarrays and their sums which is O(N^2)
2. what can we do to optimise it ; observations-->
	2.1 if we are adding positive numbers to develop a subarray while traversing the array, no problem , since we know that it is
		getting us to a maximum sum
	2.2 but if we are adding a negative number, we know that it doesn't help, so if some part of the subarray is giving a negative
		sum, we won't include it in our final sum
	2.3 if an array consists only negative numbers then the max sum is the element of the array with maximum magnitude

*/
class KadaneSAlgo{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){

        // Your code here
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0;i<n;i++)
        {
            currSum+=arr[i];

            if(maxSum<currSum)
                maxSum=currSum;

            if(currSum<0)
                currSum=0;
        }

        //means all were negatives
        if(maxSum==0)
        {
            maxSum=arr[0];
            for(int i=0;i<n;i++)
                if(arr[i]>maxSum)
                    maxSum=arr[i];
        }

        return maxSum;
    }

}

