/*
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4
Your Task:
The task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

*/
class ReverseKNodes
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        int temp=0;
        Node prev=null,next=null, curr=node;
        //first round of revrsing
        while(temp<k && curr!=null)
        {
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
            temp++;
        }
        //if more elements are left
        //recursively call
        if(next!=null)
           node.next=reverse(next,k);

        //prev is the new head
        return prev;
    }
}