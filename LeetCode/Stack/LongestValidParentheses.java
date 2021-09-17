/*
Longest Valid Parentheses
Hard

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
*/

class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        
        int res=0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                stk.push(i);
            else
            {
                if(!stk.empty())
                    stk.pop();
                if(!stk.empty())
                    res = Math.max(res , i-stk.peek());
                else
                    stk.push(i);
            }
        }
        
        return res;
        
    }
}