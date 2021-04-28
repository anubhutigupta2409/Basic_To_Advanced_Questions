/*
as we know that every time we want to push an element in a stack it gets inserted at the top of the stack, the task is to insert
an element at the end of the stack without using any other data structure
*/

import java.util.*;

public class InsertAtEnd
{
	public static Stack<Character> stk = new Stack<Character>();

	public static void insertAtEnd(char x)
	{
		if(stk.empty())
			stk.push(x);

		else
		{
			/*all stack elements are held in method call until we reach the end*/
			char a = stk.peek();
			stk.pop();

			insertAtEnd(x);

			stk.push(a);
		}
	}
	public static void main(String args[])
	{
		stk.push('a');
		stk.push('b');
		stk.push('c');
		stk.push('d');
		stk.push('e');

		System.out.println("Stack before any type of changes--> \n"+stk+"\nStack's top--> "+stk.peek());
		insertAtEnd('z');

		System.out.println("Stack after insertion at end--> \n"+stk+"\nStack's top--> "+stk.peek());
	}
}