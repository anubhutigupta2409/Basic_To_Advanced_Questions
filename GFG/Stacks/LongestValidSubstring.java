/*

Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
NOTE: Length of smallest the valid substring ( ) is 2.

Example 1:

Input: S = "(()("
Output: 2
Explanation: The longest valid
substring is "()". Length = 2.
Example 2:

Input: S = "()(())("
Output: 6
Explanation: The longest valid
substring is "()(())". Length = 6.

Your Task:
You dont need to read input or print anything. Complete the function findMaxLen() which takes S as input parameter and returns
the maxlength.


Expected Time Complexity:O(n)
Expected Auxiliary Space: O(1)


Constraints:
1 <= |S| <= 105
*/

class LongestValidSubstring {
    static int findMaxLen(String S) {
        // code here
        int n= S.length();

        Stack<Integer> stk = new Stack<>();

        stk.push(-1);

        int result =0;

        for(int i=0;i<n;i++)
        {
            if(S.charAt(i)== '(')
                stk.push(i);

            //if closing bracket
            else
            {
                //pop the previous opening bracket's index
                if(!stk.empty())
                    stk.pop();

                if(!stk.empty())
                    result = Math.max(result, i - stk.peek());

                else
                    stk.push(i);
            }
        }

        return result;
    }
};