/*
Sort Colors
Medium

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/

/*

low(l) , high(h) , mid(m)
approach--> if mid == 0 , swap low and mid ,low++ mid++
            if mid == 1 , mid++
            if mid ==2 , swap high and mid, high--
nums = [2,0,2,1,1,0] [0,0,2,1,1,2] [0,0,2,1,1,2] [0,0,2,1,1,2] [0,0,1,1,2,2]
        l         h   l       h       l     h         l   h         l h
        m             m               m               m             m
*/

class SortColors{


    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        int low=0, mid=0, high= nums.length-1;

        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }

            else if(nums[mid]==1)
                mid++;

            else if(nums[mid]==2)
            {
                swap(nums,mid,high);
                high--;
            }
        }

    }
}