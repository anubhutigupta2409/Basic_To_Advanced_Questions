/*
4Sum II

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 

Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
 

Constraints:

n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
*/
/*
Approach-->
https://leetcode.com/problems/4sum-ii/solutions/1740606/going-from-o-n-4-o-n-3-o-n-2-java-c/
*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count=0;

        Map<Integer,Integer> map = new HashMap<>();

        //for first two arrays
        for(int x : nums1)
            for(int y : nums2)
                map.put(x+y,map.getOrDefault(x+y,0)+1);

        //for next two arrays
        for(int x : nums3)
            for(int y : nums4)
                count += map.getOrDefault(-(x+y),0);

        return count;
        
    }
}
