/*
4Sum
Medium

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]


Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

/*
Brute  force --> sort+Binary Search + 3 pointers, i=0, j=i+1, k=j+1, n^3logn + hashset

better-->
sort+two pointers and two sum property on rest array (jump over duplicates), n^3
*/

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums==null || nums.length==0)
            return res;

        Arrays.sort(nums);

        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int target2 = target - (nums[i] + nums[j]);

                int low = j+1, high = n-1;

                while(low<high)
                {
                    if(nums[low]+nums[high] < target2)
                        low++;
                    else if(nums[low]+nums[high] > target2)
                        high--;
                    else
                    {
                        List<Integer> quad = new ArrayList<>();

                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[low]);
                        quad.add(nums[high]);

                        res.add(quad);

                        //jumping over duplicates
                        while(low<high && nums[low]==quad.get(2))
                            low++;
                        while(low<high && nums[high]==quad.get(3))
                            high--;
                    }
                }

                //reaching the last duplicate number, as for loop will
                //increment
                while(j+1 < n && nums[j]==nums[j+1])
                    j++;
            }

            while(i+1 < n && nums[i]==nums[i+1])
                i++;
        }

        return res;

    }
}