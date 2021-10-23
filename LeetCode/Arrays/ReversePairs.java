/*
Reverse Pairs
Hard

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
*/

class ReversePairs {
    private int merge(int nums[],int low,int mid, int high)
    {
        int inv = 0;
        int j=mid+1;//starting pt. of the right of the array
        
        //left half
        //time complexity of the following is O(n) and O(n^2) as we are           
        //performing total of n steps, as j's position doesn't depend on 
        // i;
        for(int i=low;i<=mid;i++)
        {
            while(j<=high && nums[i] > 2*(long)nums[j])
                j++;
            
            //now we know that j is at the right place
            inv += (j-(mid+1));
        }
        
        //merging
        ArrayList<Integer> temp = new ArrayList<>();
        
        int left = low, right =mid+1;
        
        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
        
        //rest
        while(left<=mid)
            temp.add(nums[left++]);
        
        while(right<=high)
            temp.add(nums[right++]);
        
        for(int i=low;i<=high;i++)
            nums[i] = temp.get(i-low);
        
        return inv;
    }
    private int mergeSort(int nums[],int low, int high)
    {
        //only one element
        if(low>=high)
            return 0;
        
        int inv = 0;
        
        int mid = low + (high-low)/2;
        
        inv+=mergeSort(nums,low,mid);
        inv+=mergeSort(nums,mid+1,high);
        
        inv+=merge(nums,low,mid,high);
        
        return inv;
    }
    public int reversePairs(int[] nums) {
        
        return mergeSort(nums,0,nums.length-1);
    }
}