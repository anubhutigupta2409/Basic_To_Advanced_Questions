/*

Merge K sorted linked lists
Medium
Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.
Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
Your Task:
The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done
automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 103
*/

class MergeKSortedLL
{
    //Function to merge K sorted linked list.
    class compareNode implements Comparator<Node>
    {
        public int compare(Node a, Node b)
        {
            return a.data-b.data;
        }
    }

    Node mergeKList(Node[]arr,int k)
    {
        //Add your code here.
        Node head=null,/*head of the merged list*/ last=null/*last of the merged list*/;
        Node top=null;//represents top of the minHeap

        //creating a minHeap
        PriorityQueue<Node> pq = new PriorityQueue<>(new compareNode());

        //adding heads of all the lists
        for(int i=0;i<k;i++)
        {
            if(arr[i]!=null)
                pq.add(arr[i]);
        }

        //now traversing the minHeap

        while(!pq.isEmpty())
        {
            top=pq.poll();

            //adding more members to the minHeap
            if(top.next!=null)
                pq.add(top.next);

            //adding it to the list
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


