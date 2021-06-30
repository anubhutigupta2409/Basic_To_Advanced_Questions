/*
nCr 
Medium 
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 

Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.

Your Task:
You do not need to take input or print anything. Your task is to complete the function nCr() which takes n and r as input parameters and returns nCr modulo 109+7..


Expected Time Complexity: O(n*r)
Expected Auxiliary Space: O(r)


Constraints:
1 = n = 1000
1 = r = 800
*/
class BinomialCoefficientProblem{
    static int mod = 1000000007;
    
    static int util(int n, int r, int dp[][])
    {
        if(r==n || r==0)
            return dp[n][r] = 1;
        if(r==1)
            return dp[n][r] = n;
        
        if(dp[n][r] != -1)
            return dp[n][r];
            
        return dp[n][r] = (util(n-1,r,dp)%mod + util(n-1,r-1,dp)%mod )%mod;
    }
    static int nCr(int n, int r)
    {
        // code here
        if(r>n)
            return 0;
            
        int dp[][] = new int[n+1][r+1];
        
        for(int row[] : dp)
            Arrays.fill(row,-1);
            
        return util(n,r,dp);
    }
}