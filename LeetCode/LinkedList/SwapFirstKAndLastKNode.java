/*
Swapping Nodes in a Linked List
Medium

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100

*/

class SwapFirstKAndLastKNode {
    private int count(ListNode head)
    {
        if(head.next == null)
            return 1;
        return 1+count(head.next);
    }
    public ListNode swapNodes(ListNode head, int k) {

        if(head==null || head.next==null)
            return head;

        int count = count(head);

        //for left
        ListNode prevL = null, left = head;

        for(int i=1;i<k;i++)
        {
            prevL = left;
            left = left.next;
        }

        //for right
        ListNode prevR = null , right = head;

        for(int i=1;i<count-k+1;i++)
        {
            prevR = right;
            right = right.next;
        }

        //changing the prev links

        if(prevL!=null)
            prevL.next = right;

        if(prevR!=null)
            prevR.next = left;

        //changing the next links
        ListNode temp = left.next;
        left.next = right.next;
        right.next = temp;

        //checking for new head positions
        if(k==1)
            head = right;
        else if(k==count)
            head = left;

        return head;

    }

}