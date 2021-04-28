/*
Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.


Example 1:

Input: S = "231*+9-"
Output: -4
Explanation:
After solving the given expression,
we have -4 as result.


Example 2:

Input: S = "123+*8-"
Output: -3
Explanation:
After solving the given postfix
expression, we have -3 as result.

Your Task:
You do not need to read input or print anything. Complete the function evaluatePostfixExpression() that takes the string S denoting the expression as input parameter and returns the evaluated value.


Expected Time Complexity: O(|S|)
Expected Auixilliary Space: O(|S|)


Constraints:
1 = |S| = 105
*/

class EvaluatePostFixExpression
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> stk = new Stack<Integer>();

        for(int i=0;i<S.length();i++)
        {
            char c= S.charAt(i);

            //if character is a digit push into stack
            if(Character.isDigit(c))
                stk.push(c - '0');//converted t0 int this way

            //else pop two elements from the stack and perform the operation
            //on those two operands and push them back
            else
            {
                int op1= stk.pop();
                int op2 = stk.pop();

                switch(c)
                {
                    case '+' :
                            stk.push(op2+op1);
                            break;

                    case '-' :
                            stk.push(op2-op1);
                            break;

                    case '/' :
                            stk.push(op2/op1);
                            break;

                    case '*' :
                            stk.push(op2*op1);
                            break;

                }
            }

        }

        return stk.pop();
    }
}