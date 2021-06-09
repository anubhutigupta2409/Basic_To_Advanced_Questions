/*
Intersection of Two Linked Lists
Easy

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Intersected at '2'
Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: No intersection
Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.
 

Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
0 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.
 

Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
*/
/*
Visualization of this solution:
Case 1 (Have Intersection & Same Len):

       a
A:     a1 ? a2 ? a3
                   \
                     c1 ? c2 ? c3 ? null
                   /           
B:     b1 ? b2 ? b3
       b
            a
A:     a1 ? a2 ? a3
                   \
                     c1 ? c2 ? c3 ? null
                   /           
B:     b1 ? b2 ? b3
            b
                 a
A:     a1 ? a2 ? a3
                   \
                     c1 ? c2 ? c3 ? null
                   /           
B:     b1 ? b2 ? b3
                 b
A:     a1 ? a2 ? a3
                   \ a
                     c1 ? c2 ? c3 ? null
                   / b            
B:     b1 ? b2 ? b3
Since a == b is true, end loop while(a != b), return the intersection node a = c1.

Case 2 (Have Intersection & Different Len):

            a
A:          a1 ? a2
                   ?
                     c1 ? c2 ? c3 ? null
                   ?            
B:     b1 ? b2 ? b3
       b
                 a
A:          a1 ? a2
                   ?
                     c1 ? c2 ? c3 ? null
                   ?            
B:     b1 ? b2 ? b3
            b
A:          a1 ? a2
                   ? a
                     c1 ? c2 ? c3 ? null
                   ?            
B:     b1 ? b2 ? b3
                 b
A:          a1 ? a2
                   ?      a
                     c1 ? c2 ? c3 ? null
                   ? b           
B:     b1 ? b2 ? b3
A:          a1 ? a2
                   ?           a
                     c1 ? c2 ? c3 ? null
                   ?      b           
B:     b1 ? b2 ? b3
A:          a1 ? a2
                   ?                a = null, then a = b1
                     c1 ? c2 ? c3 ? null
                   ?           b           
B:     b1 ? b2 ? b3
A:          a1 ? a2
                   ? 
                     c1 ? c2 ? c3 ? null
                   ?                b = null, then b = a1 
B:     b1 ? b2 ? b3
       a
            b         
A:          a1 ? a2
                   ? 
                     c1 ? c2 ? c3 ? null
                   ?
B:     b1 ? b2 ? b3
            a
                 b         
A:          a1 ? a2
                   ? 
                     c1 ? c2 ? c3 ? null
                   ? 
B:     b1 ? b2 ? b3
                 a
A:          a1 ? a2
                   ? b
                     c1 ? c2 ? c3 ? null
                   ? a
B:     b1 ? b2 ? b3
Since a == b is true, end loop while(a != b), return the intersection node a = c1.

Case 3 (Have No Intersection & Same Len):

       a
A:     a1 ? a2 ? a3 ? null
B:     b1 ? b2 ? b3 ? null
       b
            a
A:     a1 ? a2 ? a3 ? null
B:     b1 ? b2 ? b3 ? null
            b
                 a
A:     a1 ? a2 ? a3 ? null
B:     b1 ? b2 ? b3 ? null
                 b
                      a = null
A:     a1 ? a2 ? a3 ? null
B:     b1 ? b2 ? b3 ? null
                      b = null
Since a == b is true (both refer to null), end loop while(a != b), return a = null.

Case 4 (Have No Intersection & Different Len):

       a
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
       b
            a
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
            b
                 a
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
                 b
                      a
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
                      b = null, then b = a1
       b                   a = null, then a = b1
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
            b                   
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
       a
                 b
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
            a
                      b
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
                 a
                           b = null
A:     a1 ? a2 ? a3 ? a4 ? null
B:     b1 ? b2 ? b3 ? null
                      a = null
Since a == b is true (both refer to null), end loop while(a != b), return a = null.

Notice that if list A and list B have the same length, this solution will terminate in no more than 1 traversal; if both lists have different lengths, this solution will terminate in no more than 2 traversals -- in the second traversal, swapping a and b synchronizes a and b before the end of the second traversal. By synchronizing a and b I mean both have the same remaining steps in the second traversal so that it's guaranteed for them to reach the first intersection node, or reach null at the same time (technically speaking, in the same iteration) -- see Case 2 (Have Intersection & Different Len) and Case 4 (Have No Intersection & Different Len).
*/

public class IntersectionOfA_YList {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        
        if(head1==null || head2==null)
            return null;
        
        ListNode a = head1;
        ListNode b = head2;
        
        while(a!=b)
        {
            a = (a==null ? head2 : a.next);
            b = (b==null ? head1 : b.next);
        }
        
        return a;
    }
}