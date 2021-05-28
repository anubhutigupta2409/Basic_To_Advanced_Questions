/*

Minimum swaps and K together
Medium
Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less
than or equal to k together.

Example 1:

​Input : arr[ ] = {2, 1, 5, 6, 3} and K = 3
Output : 1
Explanation:
To bring elements 2, 1, 3 together, swap element '5' with '3'
such that final array will be- arr[] = {2, 1, 3, 6, 5}

​Example 2:

Input : arr[ ] = {2, 7, 9, 5, 8, 7, 4} and K = 6
Output :  2


Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function
minSwap() that takes an array (arr), sizeOfArray (n), an integer K, and return the minimum swaps required. The driver code takes
care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


Constraints:
1 = N = 105
1 = Arri, K =107
*/
class MinSwapskTogether{


    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function

        int count=0;
        //counting how many elements are smaller/equal to it
        for(int i=0;i<n;i++)
            if(arr[i]<=k)
                count++;

        //counting how many people are actually not required in our answer
        //in the current window
        int notR = 0;
        for(int i=0;i<count;i++)
            if(arr[i]>k)
                notR++;



        //the idea is to count the no. of not required elements in a current
        //window, and we update the minimum, as we need minimum swaps

        int ans=notR;//worst case we need to swap all the not required elements

        for(int i=0, j=count;j<n;i++,j++)
        {
            if(arr[i]>k)
                notR--;//decreasing count for previous window

            if(arr[j]>k)
                notR++;//increasing for current window

            ans=Math.min(ans,notR);
        }

        return ans;
    }


}
