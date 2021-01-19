/*
Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list,
elements are 6->5->4->3->2->1.
Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104
*/



class ReverseLLIterative
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        // code here
        Node prev=null, curr=head, next=null;
        while(curr!=null)
        {
            next= curr.next;//storing the next of the current element
            curr.next=prev;//the real reversing logic

            /*moving one step ahead*/
            prev=curr;
            curr=next;
        }
        head=prev;//since curr element must have reached the end that is
        //the null after the above loop
        return head;

    }
}
