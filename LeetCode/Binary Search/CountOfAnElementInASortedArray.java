/*
Given a sorted array of n elements, possibly with duplicates, find the number of occurrences of the target element.

Example 1:

Input: arr = [4, 4, 8, 8, 8, 15, 16, 23, 23, 42], target = 8
Output: 3
Example 2:

Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 6
Output: 0
Example 3:

Input: arr = [3, 5, 5, 5, 5, 7, 8, 8], target = 5
Output: 4
Expected O(logn) time solution.
*/

/*
Since we are given a sorted array, the advantage we have is the all the occurences of that particular element will be together
, in a row. So if somehow we can calculate the length of that row, we will know that what is the count. So we have calculated the last and
the first occurence of an element in a sorted array , therefore, it's count would be =
last-first+1. That's it!!
*/
class CountOfAnElementInASortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] range= {-1, -1};

        int start = 0, end = nums.length-1;

        while(start<=end)
        {
            int mid= start + (end-start)/2;

            if(target==nums[mid])
            {
                range[0] = mid;//don't directly return store it as ot can be a probable answer
                end = mid-1;//search for possible first occurence in the left subarray
            }
            else if(target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        start = 0;
        end = nums.length-1;
        while(start<=end)
        {
            int mid= start + (end-start)/2;

            if(target==nums[mid])
            {
                range[1] = mid;
                start = mid +1;//search for possible last occurence in the right subarray
            }
            else if(target<nums[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return range[1] - range[0] + 1;
    }
}