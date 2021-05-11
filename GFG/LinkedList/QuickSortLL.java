/*

Sort the given Linked List using quicksort. which takes O(n^2) time in worst case and O(nLogn) in average and best cases,
otherwise you may get TLE.

Input:
In this problem, method takes 1 argument: address of the head of the linked list. The function should not read any input from
stdin/console.
The struct Node has a data part which stores the data and a next pointer which points to the next element of the linked list.
There are multiple test cases. For each test case, this method will be called individually.

Output:
Set *headRef to head of resultant linked list.

User Task:
The task is to complete the function quickSort() which should set the *headRef to head of the resultant linked list.

Constraints:
1<=T<=100
1<=N<=200

Note: If you use "Test" or "Expected Output Button" use below example format

Example:
Input:
2
3
1 6 2
4
1 9 3 8

Output:
1 2 6
1 3 8 9

Explanation:
Testcase 1: After sorting the nodes, we have 1, 2 and 6.
Testcase 2: After sorting the nodes, we have 1, 3, 8 and 9.

*/

/*
Approavh-->
In partition(), we consider last element as pivot. We traverse through the current list and if a node has value greater than
pivot, we move it after tail. If the node has smaller value, we keep it at its current position.

In QuickSortRecur(), we first call partition() which places pivot at correct position and returns pivot. After pivot is placed
at correct position, we find tail node of left side (list before pivot) and recur for left list. Finally, we recur for right list.



*/

class QuickSortLL
{
    public static Node returnLast(Node head)
    {
        if(head==null)
            return head;

        while(head.next!=null)
            head=head.next;

        return head;
    }
    public static Node partitionLast(Node start, Node end)
    {
        if(start==null || start==end || start==end)
            return start;

        Node pivotPrev=start, curr = start;
        int pivot = end.data;

        while(start!=end)
        {
            if(start.data < pivot)
            {
                pivotPrev=curr;

                //swapping
                int temp=curr.data;
                curr.data=start.data;
                start.data=temp;

                curr=curr.next;

            }
            start=start.next;
        }

        //placing the pivot at right place
        int temp = curr.data;
        curr.data= pivot;
        end.data= temp;

        return pivotPrev;
    }
    public static void sort(Node start, Node end)
    {
        if(start==null || start==end || start==end.next)
            return;

        Node pivotPrev= partitionLast(start,end);

        //left sublist
        sort(start,pivotPrev);

        //right sublist

        //if pivot was the start
        if(pivotPrev!=null && pivotPrev==start)
            sort(pivotPrev.next, end);

        //if pivot exists somewhere between the list
        else if(pivotPrev!=null && pivotPrev.next!=null)
            sort(pivotPrev.next.next/*as we want to start from next of pivot*/, end);


    }
    public static Node quickSort(Node head)
    {
        //Your code here
        if(head==null)
            return head;

        sort(head,returnLast(head));

        return head;
    }


}