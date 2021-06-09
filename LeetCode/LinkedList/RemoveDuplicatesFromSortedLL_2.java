/*
Remove Duplicates from Sorted List II
Medium

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
Example 2:


Input: head = [1,1,1,2,3]
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

*/

class RemoveDuplicatesFromSortedLL_2 {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
            return head;
        
        ListNode curr=head;
        ListNode pre= null;
        
        while(curr!=null && curr.next!=null)
        {
            //of we dealing w a distinct node
            if(curr.val != curr.next.val)
            {
                pre=curr;
                curr=curr.next;
            }
            else
            {
                //traverse
                while(curr.next!=null && curr.val==curr.next.val)
                   curr=curr.next;//by this we reached the last duplicate node
                
                //if the first node was a distinct node, then make changes 
                if(pre!=null)
                    pre.next=curr.next;
                else
                    head=curr.next;//as the very first element is the duplicate
                
                curr=curr.next;//completely eradicate the cduplicate node from our list
            }
        }
        
        return head;
    }
}