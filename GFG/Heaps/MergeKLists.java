/*

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
The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 103
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


//same as merging k sorted arrays
class MergeKLists
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        Node head=null, last=null;

        //min heap = priority queue
        //implementing as min heap using compare method
        PriorityQueue<Node> p
            = new PriorityQueue<>(
                new Comparator<Node>() {
                    public int compare(Node a, Node b)
                    {
                        return a.data - b.data;
                    }
                });

        //push heads of all the linked lists
        for(int i=0;i<K;i++)
            if(arr[i]!=null)
                p.add(arr[i]);

        //now remove the root of the minHeap
        while(!p.isEmpty())
        {
            Node top = p.peek();
            p.remove();

            //adding next elements
            if(top.next!=null)
                p.add(top.next);

            //if final merged list is empty, both head and last element is the
            //top
            if(head == null)
            {
                head = top;
                last=top;
            }

            //else we append our top at the end and our top is the new last
            //element of the queue
            else
            {
                last.next=top;
                last=top;
            }
        }
        return head;
    }
}
