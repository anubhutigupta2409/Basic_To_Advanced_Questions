/*
Remove Duplicates from Sorted List
Easy

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.
*/
class RemoveDuplicatesFromSortedLL_1 {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)
            return head;
        
        ListNode curr=head;
        
        while(curr!=null && curr.next!=null)
        {
            if(curr.next.val == curr.val)
                curr.next= curr.next.next;//we change the next of the current and also we 
                // don't change the current that is we just change the next link and not
                //current itself, as we have to process it for further possible duplicates 
                //as well
            
            else
                curr=curr.next;
        }
        
        return head;
        
    }
}