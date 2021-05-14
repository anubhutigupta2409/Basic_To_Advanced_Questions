/*

Search in Rotated Sorted Array
Medium

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
*/

class SearchEleInRotatedSortedArray {
    public int binarySearch(int[] nums, int start, int end,int target) {


        while(start<=end)
        {
            int mid = start + (end-start)/2;//to avoid any type of overflow

            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                end = mid-1;
            else
                start=mid+1;
        }

        return -1;
    }
    public int findMin(int[] nums) {

        int n=nums.length;
        int start=0, end = n-1;


        while(start<=end)
        {
            if(nums[start]<=nums[end])
                return start;

            int mid = start + (end-start)/2;

            int next= (mid+1)%n;
            int prev= (mid+n-1)%n;

            if(nums[mid]<=nums[next] && nums[mid]<=nums[prev])
                    return mid;

            else
            {
                if(nums[start] <= nums[mid])
                        start = mid+1;
                else if(nums[mid] <= nums[end])
                        end=mid-1;
            }
        }
        return -1;

    }
    public int search(int[] nums, int target) {

        int min = findMin(nums);
        int res=-1;
        if(min!=-1)
        {
            int pos1= binarySearch(nums,0,min-1,target);
            int pos2= binarySearch(nums, min, nums.length-1,target);

             res= Math.max(pos1,pos2);
        }
        return res;
    }
}