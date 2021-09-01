/*
Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

*/

class RotateList{
    
    private int count(ListNode head)
    {
        int count=0;
        
        ListNode curr = head;
        
        while(curr!=null)
        {
            curr=curr.next;
            count++;
        }
        
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null)
            return head;
        
        int count = count(head);
        k = k%count;
        
        if(k==0)
            return head;
    
        ListNode prev = null, curr=head;
        
        int temp=1;
        
        while(curr!=null && temp!=count-k+1)
        {
            prev = curr;
            curr=curr.next;
            temp++;
        }
        
        prev.next = null;
        
        ListNode newHead = curr;
        
        while(curr!=null && curr.next!=null)
            curr=curr.next;
        
        if(curr!=null)
            curr.next = head;
        else
            newHead.next = head;
        
        head = newHead;
        
        return head;
    }
}