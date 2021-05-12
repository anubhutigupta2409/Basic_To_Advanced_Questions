/*
Rotate Doubly linked list by N nodes
Difficulty Level : Easy

Given a doubly linked list, rotate the linked list counter-clockwise by N nodes. Here N is a given positive integer and is
smaller than the count of nodes in linked list.

Examples:

Input : a  b  c  d  e   N = 2
Output : c  d  e  a  b

Input : a  b  c  d  e  f  g  h   N = 4
Output : e  f  g  h  a  b  c  d
*/

/*
Approach-->
To rotate the Doubly linked list, we need to change next of Nth node to NULL, next of last node to previous head node, and prev
of head node to last node and finally change head to (N+1)th node and prev of new head node to NULL (Prev of Head node in doubly
linked list is NULL)

So we need to get hold of three nodes: Nth node, (N+1)th node and last node. Traverse the list from beginning and stop at Nth
node. Store pointer to Nth node. We can get (N+1)th node using NthNode->next. Keep traversing till end and store pointer to last
node also. Finally, change pointers as stated above and at Last Print Rotated List using
PrintList Function.
*/
public class RotateDLLByN_Nodes
{
	public Node rotate(Node head, Node N)
	{
		if(N==0 || head==null)
			return head;

		Node curr=head;

		for(int i=1;i<N && curr!=null;i++)
			curr=curr.next;//Nth node reached

		if(curr==null)
			return head;//if N>=total Nodes

		Node NthNode = curr;

		while(curr.next!=null)
			curr=cuur.next;//last node reached

		/*
		n=2;
		null <- a <-> b <-> c <-> d <-> e -> null
		        h    nth nth.next      curr(last)
		*/

		curr.next=head;
		/*
		null <- a <-> b <-> c <-> d <-> e -> a
				h    nth nth.next      curr(last)
		*/
		head.prev=curr;
/*
		   e <- a <-> b <-> c <-> d <-> e -> a
				h    nth nth.next      curr(last)
		*/
		head=NthNode.next;
/*
		   e <- a <-> b <-> c <-> d <-> e -> a
				     nth    h        curr(last)
		*/
		head.prev=null;
/*
		   e <- a <-> b -> c <-> d <-> e -> a
				     nth    h        curr(last)
		*/
		NthNode.next=null;
		/*
		null <- c <-> d <-> e <-> a <-> b
		*/
		return head;
	}
}