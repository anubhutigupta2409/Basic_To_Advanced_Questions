/*
Remove Nth Node From End of List
Medium

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
*/
class RemoveNthNodeFromeEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
       //dummy node
        ListNode dummy = new ListNode();
        dummy.next=head;
        
        ListNode fast=dummy;
        ListNode slow=dummy;
        
        for(int i=1;i<=n;i++)
            fast=fast.next;//fast reaches the nth node at the end
        
        while(fast.next!=null)
        {
            slow=slow.next;//slow reaches the prev of the node to be deleted at the end
            fast=fast.next;//fast reaches the end of the list at the end
        }
        
        //delete
        slow.next=slow.next.next;
        
        return dummy.next;//in case head node is the one to be deleted, therefore, to be safe
    }
}