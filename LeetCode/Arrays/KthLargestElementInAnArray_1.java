/*
Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104

*/
class KthLargestElementInAnArray_1 {
    public int findKthLargest(int[] nums, int k) {

        //making a minHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //traversing the array
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);//adding elements in our min heap

            //when size becomes greater than k, pop
            if(pq.size()>k)
                pq.poll();
        }

        //return top
        return pq.peek();

    }
}