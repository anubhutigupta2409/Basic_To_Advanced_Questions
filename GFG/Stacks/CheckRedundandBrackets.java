/*
Given a string of balanced expression, find if it contains a redundant parenthesis or not. A set of parenthesis are redundant if
same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes’ if redundant else ‘No’.
Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. Given expression is valid and there are no white spaces present.
Example:


Input:
((a+b))
(a+(b)/c)
(a+b*(c-d))
Output:
Yes
Yes
No

Explanation:
1. ((a+b)) can reduced to (a+b), this Redundant
2. (a+(b)/c) can reduced to (a+b/c) because b is
surrounded by () which is redundant.
3. (a+b*(c-d)) doesn't have any redundant or multiple
brackets.
*/
import java.util.*;

public class CheckRedundandBrackets
{
	public static boolean checkRedundancy(String s)
	{
		char str[] = s.toCharArray();

		Stack<Character> stk = new Stack<>();

		for(char ch : str)
		{
			if(ch== ')')
			{
				char top = stk.peek();
				stk.pop();

				//if immediate popped elemet after a closing bracket is an opening bracket then true (redundancy exists)
				boolean flag = true;
				while(top!= '(')
				{
					if(top == '+' || top == '-' || top == '*' || top == '/')
						flag=false;

					top=stk.peek();
					stk.pop();
				}

				//if operators aren't there then no need of brackets means redundancy exists
				if(flag)
					return true;
			}
			//push till we donot encounter any closing bracket
			else
			{
				stk.push(ch);
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
	        String str = "((a+b))";

	        if(checkRedundancy(str))
	        	System.out.println("Yes");
	        else
	        	System.out.println("No");

	        str = "(a+(b)/c)";

	        if(checkRedundancy(str))
				System.out.println("Yes");
			else
				System.out.println("No");


	        str = "(a+b*(c-d))";

			if(checkRedundancy(str))
	        	System.out.println("Yes");
	        else
	        	System.out.println("No");

    }
}