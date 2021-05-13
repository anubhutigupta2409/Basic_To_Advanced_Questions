/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked
list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement
and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
*/
/*
Approach-->
Iterate through the linked list. Maintain 3 pointers named zero, one and two to point to current ending nodes of linked lists
containing 0, 1, and 2 respectively. For every traversed node, we attach it to the end of its corresponding list. Finally, we
link all three lists. To avoid many null checks, we use three dummy pointers zeroD, oneD and twoD that work as dummy headers of
three lists.
*/
class SortLLWith012
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here

        //base case
        if(head==null || head.next==null)
            return head;

        Node curr = head;//helps in traversing the list

        //dummy nodes, mark the beginning of the o, 1 and 2 as indepenedent
        //lists, do not contain any data themselves though, just mark the beginning
        //that is, their nexts consists of respective lists' heads
        Node zeroD=new Node(0);
        Node oneD=new Node(0);
        Node twoD=new Node(0);

        //real heads of respective lists
        Node zero =zeroD, one=oneD, two=twoD;

        while(curr!=null)
        {
            if(curr.data==0)
            {
                zero.next=curr;//push at end
                zero=zero.next;//now this is the last element
            }
            else if(curr.data==1)
            {
                one.next=curr;
                one=one.next;
            }
            else
            {
                two.next=curr;
                two=two.next;
            }
            curr=curr.next;
        }

        //linking the lists

        zero.next=(oneD.next!=null) ? oneD.next/*marks the beginning*/ : twoD.next;
        one.next=twoD.next;
        two.next=null;

        //update head
        head=zeroD.next;

        return head;
    }
}


