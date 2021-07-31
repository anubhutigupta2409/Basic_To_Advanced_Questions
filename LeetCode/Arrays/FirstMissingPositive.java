/*
First Missing Positive
Hard

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.



Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1


Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/

class FirstMissingPositive{

    private void swap(int nums[], int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int firstMissingPositive(int[] nums) {

        //performing swap sort
        for(int i=0 ; i<nums.length ; i++)
            while(nums[i] > 0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1])
                swap(nums , i , nums[i]-1);

        //after swapping
        for(int i=0 ; i<nums.length ; i++)
            if(nums[i]!=i+1)
                return i+1;//this also handles the case if all nums[i] are greater than nums
                          //then we have to return the 1, so the very first number satisfies
                         //the condition, and returns 0+1 = 1

        return nums.length + 1;
    }
}