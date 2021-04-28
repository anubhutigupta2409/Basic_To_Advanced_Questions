/*
Reverse a stack using recursion
*/

import java.util.*;

public class ReverseStkRecursion
{
	public static Stack<Character> stk = new Stack<Character>();

	public static void insertAtEnd(char x)
	{
		if(stk.empty())
			stk.push(x);

		else
		{
			char a = stk.peek();
			stk.pop();

			insertAtEnd(x);

			stk.push(a);
		}
	}

	public static void reverse()
	{
		if(stk.size()>0)
		{
			char x = stk.peek();
			stk.pop();

			reverse();

			insertAtEnd(x);
		}
	}

	public static void main(String args[])
	{
		stk.push('a');
		stk.push('b');
		stk.push('c');
		stk.push('d');
		stk.push('e');

		System.out.println("Stack before--> \n"+stk);

		reverse();

		System.out.println("\nStack after--> \n"+stk);
	}
}