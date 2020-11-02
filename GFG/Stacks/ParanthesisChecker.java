/*
Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 = T = 100
1 = |s| = 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class ParanthesisChecker {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();//testcases
		sc.nextLine();//buffer
		while(t-- > 0)
		{
		   
		   String s=sc.nextLine();
		   //making a stack
		   Stack<Character> stack=new Stack<>();
		   boolean isBalanced=true;
		   for(int i=0;i<s.length();i++)
		   {
		      char ch=s.charAt(i);//taking a character
		      if(ch=='{' || ch=='(' || ch=='[')
		      {
		          stack.push(ch);
		          continue;
		      }
		      //but if we haven't got any opening bracket
		      //that means our stack is still empty & we
		      //get a closing bracket,that's also a sign of
		      //unbalanced string
		      if(stack.isEmpty())
		      {
		          isBalanced=false;
		          break;
		      }
		      //getting closed brackets
		      if(ch=='}')
		      {
		        if(stack.peek()=='{')
		             stack.pop();
		        else
		        {
		            isBalanced=false;
		            break;
		        }
		      }
		      if(ch==']')
		      {
		        if(stack.peek()=='[')
		             stack.pop();
		        else
		        {
		            isBalanced=false;
		            break;
		        }
		      }
		      if(ch==')')
		      {
		        if(stack.peek()=='(')
		             stack.pop();
		        else
		        {
		            isBalanced=false;
		            break;
		        }
		      }
		   }
		   //now if our stack isn't empty means not balanced
		   //since we were popping on signs of the string to
		   //be balanced
		   if(!stack.isEmpty())
		        isBalanced=false;
		  
		    if(isBalanced)
		        System.out.println("balanced");
		  
		    else
		        System.out.println("not balanced");
		}
	}
}
