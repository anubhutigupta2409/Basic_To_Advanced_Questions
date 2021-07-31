/*
    Divide-and-conquer method.
    The maximum summation of subarray can only exists under following conditions:
    1. the maximum summation of subarray exists in left half.
    2. the maximum summation of subarray exists in right half.
    3. the maximum summation of subarray exists crossing the midpoints to left and right. 
    1 and 2 can be reached by using recursive calls to left half and right half of the subarraies. 
    Condition 3 can be found starting from the middle point to the left,
    then starting from the middle point to the right. Then adds up these two parts and return. 
    
    T(n) = 2*T(n/2) + O(n)
    this program runs in O(nlogn) time
    */
class MaxSubArray_DivideAndConquer {
    private int midSubArray(int nums[],int left, int right)
    {
        int sum = 0;
        int mid = left + (right-left)/2 ;
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        
        for(int i=mid; i>=left ; i--)
        {
            sum+=nums[i];
            leftSum = Math.max(leftSum,sum);
        }
        
        sum = 0;
        for(int j=mid+1;j<=right;j++)
        {
            sum+=nums[j];
            rightSum = Math.max(rightSum,sum);
        }
        
        return leftSum + rightSum;
    }
    private int maxSubArray(int nums[], int left, int right)
    {
        if(left==right)
            return nums[left];
        
        int mid = left + (right-left)/2;
        
        int leftSum = maxSubArray(nums,left,mid);
        int rightSum = maxSubArray(nums,mid+1,right);
        int midSum = midSubArray(nums,left,right);
        
        if(leftSum>=rightSum && leftSum>=midSum)
                return leftSum;
        else if(rightSum>=leftSum && rightSum>=midSum)
                return rightSum;
        else
            return midSum;
    }
    public int maxSubArray(int[] nums) {
        
        return maxSubArray(nums,0,nums.length - 1);
    }
}