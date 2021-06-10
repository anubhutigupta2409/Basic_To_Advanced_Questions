/*

Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false
if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 105
*/

/*
Approach-->
METHOD 2 (By reversing the list)
This method takes O(n) time and O(1) extra space.
1) Get the middle of the linked list.
2) Reverse the second half of the linked list.
3) Check if the first half and second half are identical.
4) Construct the original linked list by reversing the second half again and attaching it back to the first half


When number of nodes are even, the first and second half contain exactly half nodes. The challenging thing in this method is to
handle the case when number of nodes are odd. We don't want the middle node as part of any of the lists as we are going to
compare them for equality. For odd case, we use a separate variable 'midnode'.


*/

class IsPalindromeLL
{
    //Function to check whether the list is palindrome.
    Node reverse(Node head)
    {

        Node curr=head, next, prev=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    boolean compare(Node head1, Node head2)
    {
       while(head1!=null && head2!=null)
        {
            if(head1.val!=head2.val)
                return false;
            
            head1=head1.next;
            head2=head2.next;
        }
        return true;
    }
    boolean isPalindrome(Node head)
    {
        //Your code here
        Node slow = head, fast=head, previousToSlow=head;
        Node midNode= null, secondHalf=null;
        boolean res= true;

        if(head!=null && head.next!=null)
        {
            while(fast!=null && fast.next!=null)
            {
                fast=fast.next.next;
                previousToSlow=slow;
                slow=slow.next;
            }
        /*
        Odd-->

        1->2->3->2->1
           ps s     f

        Even-->

        1->2->2->1
           ps s    f
        */
        if(fast!=null)
        {
            midNode = slow;
            slow=slow.next;
        }
/*
        Odd-->

        1->2->3->2->1
           ps    s  f

        Even-->

        1->2->2->1
           ps s    f
        */
        secondHalf=slow;
        previousToSlow.next = null;
/*
        Odd-->
        1->2  3->2->1
           ps    s  f

        SecondHalf-->
        2->1

        Even-->
        1->2  2->1
           ps s    f

		SecondHalf-->
        2->1
        */

        secondHalf=reverse(secondHalf);
/*
        Odd-->
        1->2  3->1->2
           ps    s  f

        SecondHalf-->
        1->2

        Even-->
        1->2  1->2
           ps s    f

		SecondHalf-->
        1->2
        */

        res = compare(head,secondHalf);

        secondHalf=reverse(secondHalf);
/*
        Odd-->
        1->2  3->2->1
           ps    s  f

        SecondHalf-->
        2->1

        Even-->
        1->2  2->1
           ps s    f

		SecondHalf-->
        2->1
        */

        if(midNode!=null)
        {
            previousToSlow.next=midNode;
            midNode.next=secondHalf;
        }
        else
            previousToSlow.next=secondHalf;

/*
        Odd-->
       	1->2->3->2->1
           ps    s  f

        Even-->
        1->2->2->1
           ps s    f
        */

        }
        return res;
    }
}

