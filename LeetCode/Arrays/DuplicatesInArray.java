/*

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1


Constraints:

2 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
*/
/*
Approach-->
Proving that at least one duplicate must exist in nums is simple application of the pigeonhole principle. Here, each number in
nums is a "pigeon" and each distinct number that can appear in nums is a "pigeonhole". Because there are n+1n+1 numbers are nn
distinct possible numbers, the pigeonhole principle implies that at least one of the numbers is duplicated.

using tortoise and hare approach, just the way we find the starting point of the cycle in a linked list
Reason for why this works-->
https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation./75491
*/

class DuplicatesInArray{
    public int findDuplicate(int[] nums) {
        int slow=0, fast=0;

        do
        {
            slow= nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        slow=0;

        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
