/*

Given a BST and an integer K. Find the Kth Smallest element in the BST.

Example 1:

Input:
      2
    /   \
   1     3
K = 2
Output: 2
Example 2:

Input:
        2
      /  \
     1    3
K = 5
Output: -1


Your Task:
You don't need to read input or print anything. Your task is to complete the function KthSmallestElement() which takes the root
of the BST and integer K as inputs and return the Kth smallest element in the BST, if no such element exists return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1<=Number of nodes<=100000


*/

/*
Approach-->
use morris travel
*/

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }



class KthSmallestBST
{


    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k)
    {
        // Write your code here
       if(root==null)
        return -1;


        Node curr, pre;
        int count=0;
        int kSmall = -1;

        curr=root;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                count++;
                if(count==k)
                    kSmall=curr.data;

                curr=curr.right;

            }
            else
            {
                pre=curr.left;

                while(pre.right!=null && pre.right!=curr)
                    pre=pre.right;

                if(pre.right==null)
                {
                    pre.right =curr;
                    curr=curr.left;
                }
                else
                {
                    count++;
                    if(k==count)
                        kSmall=curr.data;

                    pre.right=null;
                    curr=curr.right;

                }
            }

        }

        return kSmall;
    }


}

