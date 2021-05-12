/*
Count triplets in a sorted doubly linked list whose sum is equal to a given value x
Difficulty Level : Medium

Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. Count triplets in the list
that sum up to a given value x.

Examples:
Input : DLL: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
Output : 2

explanation-->
The triplets are:
(2,6,9) and (4,5,8)

*/
/*
Approach-->
Traverse the doubly linked list from left to right. For each current node during the traversal, initailze two pointers
first = pointer to the node next to the current node and last = pointer to the last node of the list. Now, count pairs in the
list from first to last pointer that sum up to value (x – current node’s data) (algorithm described in this post). Add this count
to the total_count of triplets. Pointer to the last node can be found only once in the beginning.

*/
public class CountTripletsWGivenSumInDLL
{
	public int countPairs(Node first, Node second, int sum)
	{
		int count=0;

		while(first!=null && second!=null && first!=second && second.next!=null)
		{
			if(first.data + second.data == sum)
			{
				count++;

				first=first.next;
				second =second.prev;
			}
			else
			{
				if(first.data + second.data < sum)
					first=first.next;

				else
					second=second.prev;
			}
		}

		return count;
	}
	public int countTriplets(Node head, int sum)
	{
		if(head==null)
			return 0;

		int count=0;
		Node first,curr=head, last=head;

		while(last.next!=null)
			last=last.next;

		while(curr!=null)
		{
			first=curr.next;
			count+= countPairs(first,last,sum-curr.data);
			curr=curr.next;
		}

		return count;
	}
}

/*
Time Complexity: O(n2)
Auxiliary Space: O(1)
*/