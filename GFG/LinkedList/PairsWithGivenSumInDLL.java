/*
Find pairs with given sum in doubly linked list
Difficulty Level : Easy

Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value x, without using any extra space?

Example:

Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
        x = 7
Output: (6, 1), (5,2)
The expected time complexity is O(n) and auxiliary space is O(1).
*/

/*
1.Initialize two pointer variables to find the candidate elements in the sorted doubly linked list. Initialize first with the
start of the doubly linked list i.e; first=head and initialize second with the last node of the doubly linked list i.e;
second=last_node.

2.We initialize first and second pointers as first and last nodes. Here we don’t have random access, so to find the second
pointer, we traverse the list to initialize the second.

3.If current sum of first and second is less than x, then we move first in forward direction. If current sum of first and second
element is greater than x, then we move second in backward direction.

4.Loop termination conditions are also different from arrays. The loop terminates when two pointers cross each other
(second->next = first), or they become the same (first == second).

5.The case when no pairs are present will be handled by the condition “first==second”

*/

public class PairsWithGivenSumInDLL
{
	public void findPair(Node head, int sum)
	{
		if(head==null)
			return;

		Node first= head;
		Node second = head;

		boolean found = false;

		while(second.next!=null)
			second = second.next;

		while(first!=second && second.next!=first)
		{
			if(first.data+second.data == sum)
			{
				found = true;
				System.out.println("("+first.data+","+second.data+")");

				first=first.next;
				second = second.prev;
			}
			else
			{
				if(first.data + second.data < sum)
					first=first.next;
				else
					second=second.prev;
			}
		}

		if(found==false)
			System.out.println("No Pairs found");
	}
}