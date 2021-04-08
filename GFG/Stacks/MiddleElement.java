/*
Find middle element in a stack--> in O(1) time compexity
Approach--> Now in order to do operations with the middle element we observe certain posiibilities-->
1. clearly it is not possible in stack implemented as an array
2. in a singly linked list, also it is not possible
3. therefore, the idea is to use a doubly linked list
*/

import java.util.*;

public class MiddleElement
{
	class Node
	{
		Node prev;
		Node next;
		int data;

		Node(int data)
		{
			this.data = data;
		}
	}

	class stack
	{
		Node head;
		Node mid;
		int count;//count of nodes
	}

	//creating stack

	stack createStack()
	{
		stack stk = new stack();
		stk.count=0;
		return stk;
	}

	//push
	void push(stack stk, int data)
	{
		//new node
		Node newNode = new Node(data);
		//adding at top, so prev will be null
		newNode.prev=null;
		newNode.next=stk.head;

		stk.count+=1;

		//updating the middle element
		/*
		necessary in only two cases--> 1. empty list 2. odd number of nodes
		*/


		if(stk.count==1)
			stk.mid = newNode;

		else
		{
			stk.head.prev=newNode;

			if((stk.count&1)== 1 )
				stk.mid=stk.mid.prev;
		}

		stk.head = newNode;
	}

	//pop
	int pop(stack stk)
	{
		if(stk.count==0)
		{
			System.out.println("Stack Underflow");
			return -1;
		}

		Node head = stk.head;
		int element = head.data;

		stk.count-=1;

		stk.head=head.next;

		if(stk.head!=null)
			stk.head.prev = null;

		//update the mid element, if it's even count
		if((stk.count&1)==0)
			stk.mid=stk.mid.next;

		return element;
	}

	//find middle element
	int findMiddle(stack stk)
	{
		if(stk.count==0)
		{
			System.out.println("Stack Underflow!");
			return -1;
		}

		return stk.mid.data;
	}

	public static void main(String args[])
	{
		MiddleElement obj = new MiddleElement();
		stack stk = obj.createStack();

		//pushing
		obj.push(stk,1);
		obj.push(stk,2);
		obj.push(stk,3);
		obj.push(stk,4);
		obj.push(stk,5);

		System.out.println("Middle element --> "+obj.findMiddle(stk));
		System.out.println("\nElement popped -->" +obj.pop(stk));
		System.out.println("\nMiddle element now --> "+obj.findMiddle(stk));
		System.out.println("\nElement popped --> "+obj.pop(stk));
		System.out.println("\nMiddle element now --> "+obj.findMiddle(stk));
	}
}