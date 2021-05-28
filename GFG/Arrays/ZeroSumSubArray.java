/*

Subarray with 0 sum

Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

Example 1:

Input:
5
4 2 -3 1 6

Output:
Yes

Explanation:
2, -3, 1 is the subarray
with sum 0.
Example 2:

Input:
5
4 2 0 1 6

Output:
Yes

Explanation:
0 is one of the element
in the array so there exist a
subarray with sum 0.
Your Task:
You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false depending
upon whether there is a subarray present with 0-sum or not. Printing will be taken care by the drivers code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= n <= 104
-105 <= a[i] <= 105


*/
/*
Approach-
while we are traversing through the given array from left to right we store all the sums of all the subarrays in a set, then
thinking deeply we can notice that it doesnot matter how much long we go in the array ,if a subarray with sum =0 existed then
the sum of a bigger subarray will be equal to the sum of a smaller subarray we already stored. so we check if the sum already
exists
in the set we return true.
--> same approach can also be thought for a sub array with sum=k and not 0 then we have to check if the current sum-k already
exists
then return true;
*/
class ZeroSumSubArray{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //Your code here
        Set<Integer> h = new HashSet<>();

        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];

            //return true if the element is 0 (an element of an array is also
            //it's subarray)

            //return true if the sum becomes zero, as that is what we wanted

            //return true if sum already exists, as in between of adding values
            //we encountered a subarray whose sum adds up to zero, and that is why
            //we got the sum(previously stored) again
            if(arr[i]==0 || sum==0 || h.contains(sum))
                return true;

            h.add(sum);
        }

        return false;
    }

}