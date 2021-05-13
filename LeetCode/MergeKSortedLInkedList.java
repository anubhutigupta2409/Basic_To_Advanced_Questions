/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
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
class MergeKSortedLInkedList {
    class CompareNode implements Comparator<ListNode>
    {
        public int compare(ListNode a, ListNode b)
        {
            return a.val-b.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head=null, last=null, top=null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new CompareNode());

        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
                pq.add(lists[i]);
        }

        while(!pq.isEmpty())
        {
            top=pq.poll();

            if(top.next!=null)
                pq.add(top.next);

            if(head==null)
            {
                head=top;
                last=head;
            }
            else
            {
                last.next=top;
                last=top;
            }
        }
        return head;
    }
}