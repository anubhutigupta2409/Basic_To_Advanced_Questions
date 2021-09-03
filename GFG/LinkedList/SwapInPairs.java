/*
Pairwise swap of nodes in LinkeList

Given a linked list of N positive integers. You need to swap elements pairwise. Your task is to complete the function pairwise_swap().

Example 1:

Input:
N = 7
value[] = {1,2,3,4,5,6,7}
Output: 2 1 4 3 6 5 7
Explanation:The linked list after swapping
becomes: 1 2 3 4 5 6 7 -> 2 1 4 3 6 5 7.
Example 2:

Input:
N = 6
value[] = {1,2,3,4,5,6}
Output: 2 1 4 3 6 5
Explanation:The linked list after swapping
becomes: 1 2 3 4 5 6 -> 2 1 4 3 6 5.
Your Task:
You don't have to worry about input and output, you just have to complete the function pairwise_swap(). The printing is done automatically by the driver code.

Constraint:
1 <= N <= 100
1 <= Node values <= 1000

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)
*/

class SwapInPairs
{
    //Function to swap elements pairwise.

    public static Node pairwise_swap(Node node)
    {
        // your code here
        if(node==null || node.next==null)
            return node;

        Node newH = node.next;
        node.next = pairwise_swap(node.next.next);
        newH.next = node;

        return newH;
    }

}