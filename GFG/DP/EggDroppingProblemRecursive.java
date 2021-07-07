/*
Egg Dropping Puzzle
Medium
Suppose you have N eggs and you want to determine from which floor in a K-floor building you can drop an egg such that it doesn't break. You have to determine the minimum number of attempts you need in order find the critical floor in the worst case while using the best strategy.There are few rules given below.

An egg that survives a fall can be used again.
A broken egg must be discarded.
The effect of a fall is the same for all eggs.
If the egg doesn't break at a certain floor, it will not break at any floor below.
If the eggs breaks at a certain floor, it will break at any floor above.
For more description on this problem see wiki page

Example 1:

Input:
N = 2, K = 10
Output: 4
Example 2:

Input:
N = 3, K = 5
Output: 3
Your Task:
Complete the function eggDrop() which takes two positive integer N and K as input parameters and returns the minimum number of attempts you need in order to find the critical floor.

Expected Time Complexity : O(N*K)
Expected Auxiliary Space: O(N*K)

Constraints:
1<=N<=200
1<=K<=200


*/

class EggDroppingProblemRecursive
{
    //Function to find minimum number of attempts needed in
    //order to find the critical floor.
    static int eggDrop(int e, int f)
	{
	    // Your code here
	    //base case
	    /*
	    if just one or zero floors then in worst case we would take f attempts.

	    if just one egg given, we will play safely and start from the 1st floor, and then
	    will slowly go up, and in worst case, fth floor would be the threshold floor
	    */

	    if(e==1 || f==0 || f==1)
	        return f;

	    //check from the 1st floor till fth
	    int ans = Integer.MAX_VALUE;

	    for(int k=1;k<=f;k++)
	    {
	        //temp answer
	        int breaks= eggDrop(e-1,k-1);//as since here the egg broke, so above this
	        //floor they will break, so go down

	        int doesNot= eggDrop(e,f-k);//check above now

	        int temp=1+Math.max(breaks, doesNot);//max, since we have to consider the worst case

	        ans = Math.min(ans,temp);
	    }
	    return ans;
	}
}