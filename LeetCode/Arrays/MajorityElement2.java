/*
Majority Element II
Medium

Given an integer array of size n, find all elements that appear more than ? n/3 ? times.



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109


Follow up: Could you solve the problem in linear time and in O(1) space?
*/

//extension of moore's voting algorithm
/*
The essential concepts is you keep a counter for the majority number X. If you find a number Y that is not X, the current counter should deduce 1. The reason is that if there is 5 X and 4 Y, there would be one (5-4) more X than Y. This could be explained as "4 X being paired out by 4 Y".

And since the requirement is finding the majority for more than ceiling of [n/3], the answer would be less than or equal to two numbers.
So we can modify the algorithm to maintain two counters for two majorities.
*/

class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {

        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == num1)
                count1++;
            else if(nums[i] == num2)
                count2++;
            else if(count1 == 0)
            {
                num1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                num2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        //now making sure

        count1 = count2 = 0;

        for(int x : nums)
        {
            if(x==num1)
                count1++;
            else if(x==num2)
                count2++;
        }

        List<Integer> res = new ArrayList<Integer>();

        if(count1>nums.length/3)
            res.add(num1);

        if(count2>nums.length/3)
            res.add(num2);

        return res;
    }
}