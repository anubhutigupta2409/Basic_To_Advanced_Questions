/*

Split a Circular Linked List into two halves
Easy Accuracy: 50.84% Submissions: 18174 Points: 2
Given a Cirular Linked List of size N, split it into two halves circular lists. If there are odd number of nodes in the given
circular linked list then out of the resulting two halved lists, first list should have one node more than the second list.
The resultant lists should also be circular lists and not linear lists.



Example 1:

Input:
Circular LinkedList: 1->5->7
Output:
1 5
7


Example 2:

Input:
Circular LinkedList: 2->6->1->5
Output:
2 6
1 5

Your Task:
Your task is to complete the given function splitList(), which takes 3 input parameters: The address of the head of the linked
list, addresses of the head of the first and second halved resultant lists and Set the head1_ref and head2_ref to the first
resultant list and second resultant list respectively.


Expected Time Complexity: O(N)
Expected Auxilliary Space: O(1)


Constraints:
1 <= N <= 100
*/

class SplitCircularLL
{
        // Function  to split a circular LinkedList
	 void splitList(circular_LinkedList list)
    {
             // Your code here
        if(list.head==null)
            return;

        Node fast=list.head;
        Node slow=list.head;

        while(fast.next!=list.head && fast.next.next!=list.head)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        /*
        ODD-->
    	_____________
    	|           |
        1->2->3->4->5
       	      s
       	            f

       	EVEN-->
       	________________
       	|              |
       	1->2->3->4->5->6
       	      s
       	            f
        */

        if(fast.next.next==list.head)
            fast=fast.next;


        /*
        ODD-->
    	_____________
    	|           |
        1->2->3->4->5
       	      s
       	            f

       	EVEN-->
       	________________
       	|              |
       	1->2->3->4->5->6
       	      s
       	               f
        */

        list.head1=list.head;

		/*
        ODD-->
    	_____________
    	|           |
        1->2->3->4->5
       	h1    s
       	            f

       	EVEN-->
       	________________
       	|              |
       	1->2->3->4->5->6
       	h1    s
       	               f
        */

        if(list.head.next != list.head)
            list.head2=slow.next;

		/*
        ODD-->
    	_____________
    	|           |
        1->2->3->4->5
       	h1    s  h2
       	            f

       	EVEN-->
       	________________
       	|              |
       	1->2->3->4->5->6
       	h1    s  h2
       	               f
        */

        fast.next=slow.next;

		/*
        ODD-->
    	         ____
    	         |  |
        1->2->3->4->5
       	h1    s  h2
       	            f

       	EVEN-->
       	         _______
       	         |     |
       	1->2->3->4->5->6
       	h1    s  h2
       	               f
        */

        slow.next=list.head;

		/*
        ODD-->
        _______  ____
    	|     |  |  |
        1->2->3  4->5
       	h1    s  h2
       	            f

       	EVEN-->
       	_______  _______
        |     |  |     |
       	1->2->3  4->5->6
       	h1    s  h2
       	               f
        */

	}
}
