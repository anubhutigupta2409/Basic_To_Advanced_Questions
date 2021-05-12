/*
Reverse a doubly linked list in groups of given size
Difficulty Level : Medium

Given a doubly linked list containing n nodes. The problem is to reverse every group of k nodes in the list.

Example-->
Original list: 10 8 4 2 , k=2
Modified list: 8 10 2 4
*/

/*
Approach-->
1.reverse the linked list by pushing the node in front every time.we create a push function that adds the given node at the
beginning of the given list. We traverse the original list and one by one pass the current node pointer to the push function.
This process will reverse the list. Finally return the new head of this reversed list.
2.After reversing the group of k nodes the function checks whether next group of nodes exists in the list or not. If group exists
then it makes a recursive call to itself with the first node of the next group and makes the necessary adjustments with the next
and previous links of that group. Finally it returns the new head node of the reversed group.
*/
public class ReverseKNodesInDLL
{
	public Node push(Node head, Node newNode)
	{
		newNode.prev=null;
		newNode.next=head;

		if(head!=null)
			head.prev=newNode;

		head=newNode;

		return head;
	}

	public Node reverse(Node head, int k)
	{
		if(head==null)
			return head;

		Node curr=head, next, newHead=null;
		int count=0;

		while(curr!=null && count<k)
		{
			next=curr.next;
			newHead=push(newHead,curr);
			curr=next;
			count++;
		}

		if(next!=null)
		{
			head.next=reverse(next,k);
			head.next.prev=head;
		}

		return newHead;
	}
}