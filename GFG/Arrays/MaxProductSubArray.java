/*
Maximum Product Subarray 
Medium 
Given an array Arr that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is 6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 = N = 500
-102 = Arri = 102


*/
class MaxProductSubArray{
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long minVal = arr[0];
        long maxVal = arr[0];
        
        long maxProduct=arr[0];
        
        for(int i=1;i<n;i++)
        {
            //when multiplied w a negative number maxValue and minValue 
            //interchanges
            
            if(arr[i]<0)
            {
                long temp=maxVal;
                maxVal=minVal;
                minVal = temp;
            }
            
            //as we have two options, if the next element adds up to the path 
            //of getting a max product, then include it in our ans subarray,
            //otherwise don't, that is start with a new subarray
            
            maxVal = Math.max(arr[i],maxVal*arr[i]);
            minVal = Math.min(arr[i],minVal*arr[i]);
            
            maxProduct = Math.max(maxProduct,maxVal);
        }
        return maxProduct;
    }
}