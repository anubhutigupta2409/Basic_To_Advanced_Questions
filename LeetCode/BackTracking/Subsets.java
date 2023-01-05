/*
Subsets

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

lass Solution {
    public List<List<Integer>> subsets(int[] nums) {

        //result List
        List<List<Integer>> res = new ArrayList<>();

        bt(res, new ArrayList<>(), nums, 0);

        return res;
        
    }
   private void bt(List<List<Integer>> res, List<Integer> list, int[] nums, int start)
    {
        //will be added regardless
        res.add(new ArrayList<>(list));
        
        for(int i=start;i<nums.length;i++)
        {
            list.add(nums[i]);
            bt(res, list, nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
