/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= N <= 105

*/

/*
Approach-->
mergeSort():


1.If the size of the linked list is 1 then return the head
2.Find mid using The Tortoise and The Hare Approach
3.Store the next of mid in head2 i.e. the right sub-linked list.
4.Now Make the next midpoint null.
5.Recursively call mergeSort() on both left and right sub-linked list and store the new head of the left and right linked list.
6.Call merge() given the arguments new heads of left and right sub-linked lists and store the final head returned after merging.
7.Return the final head of the merged linkedlist.

merge(head1, head2):


1.Take a pointer say merged to store the merged list in it and store a dummy node in it.
2.Take a pointer temp and assign merge to it.
3.If the data of head1 is less than the data of head2, then, store head1 in next of temp & move head1 to the next of head1.
4.Else store head2 in next of temp & move head2 to the next of head2.
5.Move temp to the next of temp.
6.Repeat step 3, 4 & 5 until head1 is not equal to null and head2 is not equal to null.
7.Now add any remaining nodes of the first or the second linked list to the merged linked list.
8.Return the next of merged(that will ignore the dummy and return the head of the final merged linked list)
*/

class MergeSortLL
{
    //Function to sort the given linked list using Merge Sort.
    static Node findMid(Node head)
    {

        if(head==null)
            return head;

        Node fast = head.next;
        Node slow = head;

        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    static Node merge(Node head1, Node head2)
    {

        Node merged = new Node(-1);
        Node temp = merged;

        while(head1!=null && head2!=null)
        {
            if(head1.data < head2.data)
            {
                temp.next=head1;
                head1=head1.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
            }

            temp = temp.next;
        }

        while(head1!=null)
        {
            temp.next = head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null)
        {
            temp.next = head2;
            head2=head2.next;
            temp=temp.next;
        }

        return merged.next;
    }
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head.next==null)
            return head;

        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;

        Node newHead1 = mergeSort(head);
        Node newHead2 = mergeSort(head2);

        return merge(newHead1, newHead2);
    }
}


