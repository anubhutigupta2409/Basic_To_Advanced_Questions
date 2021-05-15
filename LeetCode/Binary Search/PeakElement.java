/*

Find Peak Element
Medium

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -8.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.
*/

/*
Observation-->
1.if peak element is somewhere in between the array then it has to be greater than both it's neighbours
2.if we are at first element, then it has to be greater than the element to it's right to be the peak element
3.if we are at last element, then it has to be smaller than the element to it's left to be the peak element

Approach-->
1. To check mid element check arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]
2. else move to the greater side

5 10 20 15		--> 10>5 but 10<20 therefore now we sould move to right side as 20 is already greater to one of it's neighbours
  m

3.At the end for edge elements
*/
class PeakElement {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;//if only one element then that is the peak element

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