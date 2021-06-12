/*
Add Two Numbers II
Medium

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.


Follow up: Could you solve it without reversing the input lists?
*/
class AddTwoNumbers_II {
    public ListNode reverse(ListNode root)
    {
        if(root==null||root.next==null)
            return root;

        ListNode prev=null, curr=root, next=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        l1=reverse(l1);
        l2=reverse(l2);

        ListNode head=null, prev=null, temp=null;

        int sum, carry=0;

        while(l1!=null || l2!=null)
        {
            sum = carry + (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0);

            carry = (sum>=10 ? sum/10 : 0);

            sum %= 10;

            temp = new ListNode(sum);

            if(head==null)
                head = temp;

            else
                prev.next = temp;

            prev=temp;

            if(l1!=null)
                l1=l1.next;

            if(l2!=null)
                l2=l2.next;
        }

        if(carry>0)
            temp.next= new ListNode(carry);

        return reverse(head);

    }
}