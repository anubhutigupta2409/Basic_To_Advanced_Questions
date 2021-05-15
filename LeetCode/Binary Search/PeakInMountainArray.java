/*

Peak Index in a Mountain Array

Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
Example 4:

Input: arr = [3,4,5,1]
Output: 2
Example 5:

Input: arr = [24,69,100,99,79,78,67,36,26,19]
Output: 2


Constraints:

3 <= arr.length <= 104
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

*/

/*
Observations-->
1. this mountain array is also called bitonic array, meaning -->
in the array elements only monotonically(no two adj elements are same) increasing, reach a peak and then monotonically decreasing
2.therefore, same as finding a peak element
*/

class PeakInMountainArray{
    public int peakIndexInMountainArray(int[] nums) {

        int n=nums.length;
        int start=0, end=n-1;


        while(start<=end)
        {
            int mid = start+(end-start)/2;

            if(mid>0 && mid<n-1)
            {
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                    return mid;

                else if(nums[mid-1]>nums[mid])
                    end=mid-1;//left

                else if(nums[mid+1]>nums[mid])
                    start= mid+1;//right
            }
            //starting element
            else if(mid==0)
            {
                if(nums[mid] > nums[1])
                    return mid;
                else
                    return 1;
            }
            //ending element
            else if(mid==n-1)
            {
                if(nums[mid]>nums[n-2])
                    return mid;
                else
                    return n-2;
            }
        }
        return -1;


    }
}