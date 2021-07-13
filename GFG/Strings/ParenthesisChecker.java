/*
Parenthesis Checker

Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.

Example 1:

Input:
{([])}
Output:
true
Explanation:
{ ( [ ] ) }. Same colored brackets can form
balaced pairs, with 0 number of
unbalanced bracket.
Example 2:

Input:
()
Output:
true
Explanation:
(). Same bracket can form balanced pairs,
and here only 1 type of bracket is
present and in balanced way.
Example 3:

Input:
([]
Output:
false
Explanation:
([]. Here square bracket is balanced but
the small bracket is not balanced and
Hence , the output will be unbalanced.
Your Task:
This is a function problem. You only need to complete the function ispar() that takes a string as a parameter and returns a boolean value true if brackets are balanced else returns false. The printing is done automatically by the driver code.

Expected Time Complexity: O(|x|)
Expected Auixilliary Space: O(|x|)

Constraints:
1 = |x| = 32000

Note: The drive code prints "balanced" if function return true, otherwise it prints "not balanced".
*/

class ParenthesisChecker
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here

        //make a stack
        Stack<Character> stk = new Stack<>();

        for(int i=0;i<x.length();i++)
        {
            char ch = x.charAt(i);

            //opening brackets are pushed and continued
            if(ch=='(' || ch=='{' || ch=='[')
            {
                stk.push(ch);
                continue;
            }

            //no opening bracket present
            if(stk.empty())
                return false;

            //check for corresponding brackets
            if(ch=='}')
            {
                if(stk.peek()=='{')
                    stk.pop();
                else
                    return false;
            }
            if(ch==')')
            {
                if(stk.peek()=='(')
                    stk.pop();
                else
                    return false;
            }
            if(ch==']')
            {
                if(stk.peek()=='[')
                    stk.pop();
                else
                    return false;
            }
        }

        if(stk.empty())
            return true;
        else
            return false;
    }
}
