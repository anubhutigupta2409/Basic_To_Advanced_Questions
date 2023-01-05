/*
Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bt(res,new ArrayList<>(), nums);
        return res;
        
    }
    private void bt(List<List<Integer>> res, List<Integer> list, int[] nums)
    {
        if(list.size()==nums.length)
            res.add(new ArrayList<>(list));
        else
        {
            for(int i=0;i<nums.length;i++)
            {
                if(list.contains(nums[i]))
                    continue;
                list.add(nums[i]);
                bt(res, list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
