/*

Given a singly linked list, remove all the nodes which have a greater value on its following nodes.

Example 1:

Input:
LinkedList = 12->15->10->11->5->6->2->3
Output: 15 11 6 3
Explanation: Since, 12, 10, 5 and 2 are
the elements which have greater elements
on their next node. So, after deleting
them, the linked list would like be 15,
11, 6, 3.
Example 2:

Input:
LinkedList = 10->20->30->40->50->60
Output: 60
Your Task:
The task is to complete the function compute() which should modify the list as required and return the head of the modified linked list. The printing is done by the driver code,

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= size of linked list <= 1000
1 <= element of linked list <= 1000
*/
/*
Approach-->

traverse the list from start and delete the node when the current Node < next Node. To delete the current node, follow this
approach




let us assume you have to delete current node X




1. Copy next node's data into X i.e X.data = X.next.data




2. Copy next node's next address i.e X.next = X.next.next;




Move forward in the List only when current Node is > next Node.
*/
class DeleteNodesWithGreaterNextNode
{
    Node compute(Node head)
    {
        // your code here
        if(head==null || head.next==null)
            return head;

        //gives the next eligible node, the node which is computed with
        //necessary nodes deleted
        Node nextNode = compute(head.next);

        if(nextNode.data>head.data)
            return nextNode;//since head should be deleted
        else
            head.next = nextNode;//link the head to the required next node
            //that is the node which has data smaller to it

        return head;

    }
}

