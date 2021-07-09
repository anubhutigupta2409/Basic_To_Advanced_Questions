/*
Smallest sum contiguous subarray
Difficulty Level : Easy
Last Updated : 19 May, 2021
Given an array containing n integers. The problem is to find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
Examples:


Input : arr[] = {3, -4, 2, -3, -1, 7, -5}
Output : -6
Subarray is {-4, 2, -3, -1} = -6

Input : arr = {2, 6, 8, 1, 4}
Output : 1
*/
class SmallestSumContiguousSubarray
{
static int smallestSumSubarr(int arr[], int n)
	{
		//curr Sum and min Sum
      	int currSum = Integer.MAX_VALUE;
      	int minSum = Integer.MAX_VALUE;

      //check if all the elements are positive
      	int j;
      	for(j=0;j<n;j++)
          	if(arr[j]<0)
              	break;

      	if(j>=n)
        {
          	for(int i=0;i<n;i++)
              	minSum = Math.min(minSum , arr[i]);
        }

      	for(int i=0;i<n;i++)
        {
          	//variation
          	if(currSum>0)
              	currSum = arr[i]; //if currSum was
          	//greater than zero, skip that subarray
          	else
          		currSum+=arr[i];
          	minSum = Math.min(minSum,currSum);
        }

      	return minSum;
	}
}