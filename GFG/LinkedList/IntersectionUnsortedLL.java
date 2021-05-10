/*
Intersection Point in Y Shapped Linked Lists
Medium
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.



Example 1:

Input:
LinkList1 = 3->6->9->common
LinkList2 = 10->common
common = 15->30->NULL
Output: 15
Explanation:
Y ShapedLinked List
Example 2:

Input:
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
Explanation:

4              5
|              |
1              6
 \             /
  8   -----  1
   |
   4
   |
  5
  |
  NULL
Your Task:
You don't need to read input or print anything. The task is to complete the function intersetPoint() which takes the pointer to
the head of linklist1(head1) and linklist2(head2) as input parameters and returns data value of a node where two linked lists
intersect. If linked list do not merge at any point, then it should return -1.
Challenge : Try to solve the problem without using any extra space.



Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)



Constraints:
1 = N + M = 2*105
-1000 = value = 1000
*/

/*
Approach-->
1.Get count of the nodes in the first list, let count be c1.
2.Get count of the nodes in the second list, let count be c2.
3.Get the difference of counts d = abs(c1 - c2)
4.Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes
5.Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by
comparing the address of the nodes)

*/

class IntersectionUnsortedLL
{
    int count(Node head)
    {
        int count = 0;
        while(head!=null)
        {
            head= head.next;
            count++;
        }

        return count;
    }
    //assuming that the first list is bigger
    int getIntersection(int diff, Node head1, Node head2)
    {
        int i;
        Node current1 = head1;
        Node current2 = head2;

        for(i=0;i<diff;i++)
        {
            if(current1==null)
                return -1;

            current1 = current1.next;
        }
        while(current1 != null && current2 != null)
        {
        //comparing the addresses ,since data can be equal in between also
            if(current1==current2)
                return current1.data;

            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
         // code here

         if(head1 == null || head2==null)
            return -1;

         int count1 = count(head1);
         int count2 = count(head2);

         int diff;

         if(count1>count2)
         {
             diff = count1-count2;
             return getIntersection(diff, head1,head2);
         }
         else
         {
             diff = count2-count1;
             return getIntersection(diff, head2,head1);
         }
	}
}


