/*
Nth node from end of linked list
Easy
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Example 1:

Input:
N = 2
LinkedList: 1->2->3->4->5->6->7->8->9
Output: 8
Explanation: In the first example, there
are 9 nodes in linked list and we need
to find 2nd node from end. 2nd node
from end os 8.
Example 2:

Input:
N = 5
LinkedList: 10->5->100->5
Output: -1
Explanation: In the second example, there
are 4 nodes in the linked list and we
need to find 5th from the end. Since 'n'
is more than the number of nodes in the
linked list, the output is -1.
Your Task:
The task is to complete the function getNthFromLast() which takes two arguments: reference to head and N and you need to return
Nth from the end or -1 in case node doesn't exist..

Note:
Try to solve in single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= L <= 103
1 <= N <= 103
*/
/*
Easy approach-->

class GfG
{
    //Function to find the data of nth node from the end of a linked list.
    int count(Node head)
    {
        int count=0;
        Node temp=head;

        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }
    int  getNthFromLast(Node head, int n)
    {
    	// Your code here
    	if(head==null || count(head)<n )
    	    return -1;

    	Node curr=head;

    	int i=0;
    	for(i=1;i<count(head)-n+1;i++)
    	{
    	    curr=curr.next;
    	}

    	if(curr!=null)
    	    return curr.data;

    	 else
    	    return -1;

    }
}
*/

/*
Better Approach-->

Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. First, move the
reference pointer to n nodes from head. Now move both pointers one by one until the reference pointer reaches the end. Now the
main pointer will point to nth node from the end. Return the main pointer.
*/

class NthNodeFromEndLL
{
    //Function to find the data of nth node from the end of a linked list.

    int  getNthFromLast(Node head, int n)
    {
    	// Your code here
    	if(head==null)
    	    return -1;

    	 int count=0;
    	 Node first=head, second=head;
    	 while(count<n)
    	 {
    	     if(second==null)
    	        return -1;//means n>total no. of nodes
    	     second=second.next;
    	     count++;
    	 }

    	 if(second==null)
    	    return head.data;//means n== total nodes


    	 while(second!=null)
    	 {
    	    first=first.next;
    	    second=second.next;
    	 }

    	 return first.data;

    }
}

