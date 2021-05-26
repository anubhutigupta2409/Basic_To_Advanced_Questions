/*

Next Permutation
Medium

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/
class NextPermuation2{
    public void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void nextPermutation(int[] nums) {

        int n=nums.length;

        if(n<=1)
            return ;

        int i;

        for(i=n-1;i>0;i--)
            if(nums[i]>nums[i-1])
                break;

        if(i==0)
        {
            Arrays.sort(nums);
            return;
        }

        int min/*smallest greater element*/=i;
        int minEle=nums[i-1];

        for(int j=i+1;j<n;j++)
            if(nums[j]>minEle && nums[j]<nums[min])
                min=j;

        swap(nums,i-1,min);

        Arrays.sort(nums,i,n);

    }
}