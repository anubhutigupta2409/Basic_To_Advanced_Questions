/*
Given a Binary Tree, write a function to populate next pointer for all nodes. The next pointer for every node should be set to point to inorder successor.

Example 1:

Input:
3
10 8 L 8 3 L 10 12 R

Output:
3->8 8->10 10->12 12->-1
Your Task:
You do not need to read input or print anything. Complete the function populateNext() that takes the root node of the binary tree as input parameter.


Constraints:
1<=T<=10^5
1<=n<=10^5
1<=data of the node<=10^5
*/

class PopulateNext1
{
    public static Node findSmallest(Node root)
    {
        if(root==null || root.left==null)
            return root;
            
        return findSmallest(root.left);
    }
    public static void populateNext(Node root)
    {
        //Add your code here.
        if(root==null)
            return;
        
        root.next = findSmallest(root.right);
        
        populateNext(root.left);
        populateNext(root.right);
    }
}