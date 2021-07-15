/*
Count the Reversals
Medium
Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.

Example 1:

Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.
​Example 2:

Input:
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countRev() which takes the string S as input parameter and returns the minimum number of reversals required to balance the bracket sequence. If balancing is not possible, return -1.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).

Constraints:
1 = |S| = 105


*/
class CountReversals
{
    int countRev (String s)
    {
        // your code here

        //if odd number of brackets, it can never be balanced
        int n= s.length();

        if((n&1)==1)
            return -1;

        //stack
        Stack<Character> stk = new Stack<>();
        int countO = 0, countC=0;

        //traversing
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);

            if(ch=='{')
            {
                stk.push(ch);
                countO++;
            }
            else if(ch=='}' && !stk.empty() && stk.peek()=='{')
            {
                stk.pop();
                countO--;//as it is balanced
            }
            else
                countC++;
        }

        //if odd then n/2+1 reversals required, if even then n/2 reversals required

        if((countC&1)==1)
            countC = countC/2 + 1;
        else
            countC = countC/2;

        if((countO&1)==1)
            countO = countO/2 + 1;
        else
            countO = countO/2;


        return countC+countO;
    }
}