/*
Sort a k sorted doubly linked list
Difficulty Level : Medium

Given a doubly linked list containing n nodes, where each node is at most k away from its target position in the list. The
problem is to sort the given doubly linked list.
For example, let us consider k is 2, a node at position 7 in the sorted doubly linked list, can be at positions 5, 6, 7, 8, 9 in
the given doubly linked list.
Examples:

Input : DLL : 3 <-> 6 <-> 2 <-> 12 <-> 56 <-> 8
		k : 2
Output : null <- 2 <-> 3 <-> 6 <-> 8 <-> 12 <-> 56 -> null
*/

/*
Approach-->
We can sort the list using the MIN HEAP data structure.

*/
public class SortKSortedDLL
{
	class CompareNode implements Comparator<Node>
	{
		public int compare(Node n1, Node n2)
		{
			return n1.data-n2.data;//for minHeap
		}
	}

	public Node sort(Node head, int k)
	{
		if(head==null)
			retur head;

		PriorityQueue<Node>  pq = new PriorityQueue<>(new CompareNode());

		for(int i=0;i<=k && head!=null ;i++)
		{
			pq.add(head);

			head=head.next;
		}

		Node newHead=null, last;

		while(!pq.isEmpty())
		{
			if(newHead==null)
			{
				newHead= pq.peek();
				newHead.prev=null;
				last=newHead;
			}
			else
			{
				last.next=pq.peek();
				pq.peek().prev=last;
				last=pq.peek();
			}

			if(head!=null)
			{
				pq.add(head);
				head=head.next;
			}
		}

		last=last.next;

		return newHead;
	}
}
/*
Time Complexity: O(n*log k)
Auxiliary Space: O(k)
*/