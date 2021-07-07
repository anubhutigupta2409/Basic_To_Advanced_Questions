/*
Stickler Thief
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.

Example 1:

Input:
n = 6
a[] = {5,5,10,100,10,5}
Output: 110
Explanation: 5+100+5=110
Example 2:

Input:
n = 3
a[] = {1,2,3}
Output: 4
Explanation: 1+3=4
Your Task:
Complete the function FindMaxSum() which takes an array arr[] and n as input which returns the maximum money he can get following the rules

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).

Constraints:
1 = n = 104
1 = a[i] = 104
*/

class FindMaxSumSuchThatNoElementsAreConsecutive
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        //dp array
        int dp[] = new int[n];

        for(int i=0;i<n;i++)
            dp[i] = arr[i];

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(i-j > 1)
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
            }
        }

        int ans= Integer.MIN_VALUE;

        for(int i : dp)
            ans = Math.max(ans,i);

        return ans;
    }
}

/*
Time Complexity --> O(n^2)
*/