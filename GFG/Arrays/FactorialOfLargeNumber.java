/*
Factorials of large numbers 
Medium Accuracy: 62.19% Submissions: 7001 Points: 4
Given an integer N, find its factorial.

Example 1:

Input: N = 5
Output: 120
Explanation : 5! = 1*2*3*4*5 = 120

Example 2:

Input: N = 10
Output: 3628800
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

Your Task:
You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

 

Constraints:
1 = N = 1000


*/
class FactorialOfLargeNumber {
    static void multiply(int x, ArrayList<Integer> res)
    {
        int carry=0;
        
        for(int i=0;i<res.size();i++)
        {
            int product = res.get(i)*x + carry;
            res.set(i,product%10);//just the last digit of the product
            carry=product/10;//first digit of the product
        }
    
        while(carry!=0)
        {
            res.add(carry%10);
            carry=carry/10;
        }
    }
    static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer> res = new ArrayList<>();
        
        res.add(1);
        if(N==0)
            return res;//0!=1
            
        for(int x=2;x<=N;x++)
            multiply(x,res);
        
        Collections.reverse(res);//list will be in reversed form
        
        return res;
            
    }
}