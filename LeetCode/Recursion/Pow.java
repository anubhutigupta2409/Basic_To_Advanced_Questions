/*
Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
-104 <= xn <= 104
*/

class Solution {
    private double util(double x, int n) {
        
        if(n==0)
            return 1;
        if(n==1)
            return x;
        
        if((n&1)==1)
            return x*util(x,n-1);
        else
            return util(x*x,n/2);
    }
    public double myPow(double x, int n)
    {
        
        if(n<0)
            return (1/x)*util(1/x,-(n+1));//to prevent integer overflow
        else
            return util(x,n);
    }
}
