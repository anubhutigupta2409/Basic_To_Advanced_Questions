/*
Sort an Array
Medium

Given an array of integers nums, sort the array in ascending order.



Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]


Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/

//performing heap sort

class HeapSort {

    private void heapify(int[] nums, int n, int i)
    {
        int largest = i;

        int left = 2*i+1, right = 2*i+2;

        if(left<n && nums[largest] < nums[left])
            largest = left;

        if(right<n && nums[largest] < nums[right])
            largest = right;

        if(largest!=i)
        {
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;

            heapify(nums,n,largest);
        }
    }

    public int[] sortArray(int[] nums) {

        //building heap
        int n = nums.length;

        for(int i = n/2 - 1;i>=0;i--)
            heapify(nums,n,i);

        //deletion

        for(int i= n-1;i>0;i--)
        {
            //swapping w root node
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //heapify, heap's size reduces
            heapify(nums,i,0);
        }

        return nums;

    }
}