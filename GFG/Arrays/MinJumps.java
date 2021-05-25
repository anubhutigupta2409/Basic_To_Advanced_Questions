/*
Minimum number of jumps
Medium Accuracy: 32.96% Submissions: 80458 Points: 4
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.

Example 1:

Input:
N = 11
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3
Explanation:
First jump from 1st element to 2nd
element with value 3. Now, from here
we jump to 5th element with value 9,
and from here we will jump to last.
Example 2:

Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2
Explanation:
First we jump from the 1st to 2nd element
and then jump to the last element.
Your task:
You don't need to read input or print anything. Your task is to complete function minJumps() which takes the array arr and it's size N as input parameters and returns the minimum number of jumps.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constraints:
1 = N = 107
0 = ai = 107

*/
/*
Approachh->
1. First visit this subset of this problem-->

https://github.com/anubhuti199301171/Basic_To_Advanced_Questions/blob/master/LeetCode/Arrays/JumpGame.java
*/

class MinJumps{
    static int minJumps(int[] arr){
        // your code here
        int n=arr.length;

        if(n<=1)
            return 0;
        else if(arr[0]==0)
            return -1;
        else
        {
            int reachable = arr[0];//max index we can reach
            int step= arr[0];//max step we can take
            int jump = 1;

            for(int i=1;i<n;i++)
            {
                if(i==n-1)
                    return jump;

                reachable = Math.max(reachable,i+arr[i]);
                step--;

                if(step==0/*now we need to jump*/)
                {
                    jump++;
                    if(reachable<=i)
                        return -1;//we reached a point where we couldn't reach by jumping

                    step=reachable-i;//new possible number of steps
                }
            }

            return -1;
        }
    }
}