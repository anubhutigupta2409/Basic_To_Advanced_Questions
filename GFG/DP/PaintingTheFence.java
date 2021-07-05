/*
Painting the Fence
Medium
Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color. Since answer can be large return it modulo 10^9 + 7.


Example 1:

Input:
N=3,  K=2
Output: 6
Explanation: We have following possible combinations:


Example 2:

Input:
N=2,  K=4
Output: 16

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function countWays() that takes n and k as parameters and returns the number of ways in which the fence can be painted.(modulo 109 + 7)



Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).



Constraints:
1 = N = 105
1 = K = 100
*/
class PaintingTheFence
{
    long mod = 1000000007;

    long countWays(int n,int k)
    {
        //code here.

        /*
        if n==1, then there are k ways to paint the fence, each posts get one of
        the k colours, in each way
        */

        //base case
        if(n==0)
            return 0;
        if(n==1)
            return k%mod;

        /*
        if n==2, and ATQ we can make have atmost "2" adj posts with the same color.
        so, ways in which the two would have same colour = k ways
        ways in which the two would have diff colour = k*(k-1) ways (since, the second post has to choose from  k-1 colors)
        */

        long same = k%mod;
        long diff = (k*(k-1))%mod;

        /*
        if n==3
        1. the two behind the third posts have same colours, then third has to be diff
           ways = (same)*(k-1)
        2. the two behind has different colours then-->
           2.1 third can have the same colour ways = diff*1
           2.2 third can have diff colour ways = diff*(k-1)
        */
        /*
        So, we deduce, for nth post to have same colour, ways = diff*1
        and for nth post to have diff colour as of (n-1)th post, ways = (same+diff)*(k-1)
        */

        for(long i=3;i<=n;i++)
        {
            long prev = diff%mod;

            diff = ((same+diff)*(k-1))%mod;
            same = prev;
        }

        return (same+diff)%mod;
    }
}