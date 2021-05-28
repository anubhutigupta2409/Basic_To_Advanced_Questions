/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than [n / 2] times. You may assume that the majority element always exists
in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1


Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

class MajorityElement {
    public int majorityElement(int[] nums) {

        int ansIndex=0,count=1;//as nums[0] exists therefore, count==1
        int i;
        for(i=1;i<nums.length;i++)
        {
            //if the next element is equal to our ans element
            if(nums[i]==nums[ansIndex])
                count++;
            else
                count--;//count always belongs to the ans element

            if(count==0)
            {
               //then new ans element
                ansIndex=i;
                count=1;
            }
        }

        /* here it's told to assume that it's there's alwways a majority element, here's the
        code, to check if a majority element exists */

        count =0;
        for(i=0;i<nums.length;i++)
            if(nums[i]==nums[ansIndex])
                count++;
        if(!(count> nums.length/2))
            return -1;

        return nums[ansIndex];



    }
}