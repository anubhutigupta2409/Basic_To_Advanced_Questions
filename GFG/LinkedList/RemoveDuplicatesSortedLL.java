/*

Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given
list (if exists).
Note: Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.

Example 1:

Input:
LinkedList: 2->2->4->5
Output: 2 4 5
Explanation: In the given linked list
2 ->2 -> 4-> 5, only 2 occurs more
than 1 time.
Example 2:

Input:
LinkedList: 2->2->2->2->2
Output: 2
Explanation: In the given linked list
2 ->2 ->2 ->2 ->2, 2 is the only element
and is repeated 5 times.
Your Task:
The task is to complete the function removeDuplicates() which should remove the duplicates from linked list and return the head
of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= Number of nodes <= 104
*/

class RemoveDuplicatesSortedLL
{
    // head: head node
    Node removeDuplicates(Node root)
    {
	// Your code here
	    Node curr=root;
	    while(curr!=null)
	    {
	        Node temp= curr;//a temp element

	        //since this is a sorted ll then, duplicate nodes can be found in adjacent positions therefore, traverse till the
	        //point the data is equal
	        while(temp!=null && temp.data==curr.data)
	            temp=temp.next;

	        //after we reach the node which is no longer equal to the current node, then link the current node with this node
	        //that automatically removes all the duplicate nodes from the linked list
	        curr.next=temp;
	        curr=curr.next;
	    }
	    return root;
    }
}