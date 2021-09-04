/*
Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //recursive
class SwapPairs{
    public ListNode swapPairs(ListNode head) {

        //base condition
        if(head==null || head.next==null)
            return head;

        ListNode newH = head.next;
        head.next = swapPairs(head.next.next);
        newH.next = head;

        return newH;

    }
}

//iterative
class Solution {
 
    public ListNode swapPairs(ListNode head) {

        //base condition
        if(head==null || head.next==null)
            return head;

        ListNode curr = head , newH = head.next;

        while(curr!=null && curr.next!=null)
        {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
            curr.next = temp;

            //moving forward
            curr = temp.next;
            if(curr!=null && curr.next != null)
                temp.next = curr.next;

        }


        return newH;



    }
}
