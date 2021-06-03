/*
Boundary Traversal of binary tree
Medium
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree.
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

Example 1:

Input:
        1
      /   \
     2     3

Output: 1 2 3

Example 2:

Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \
       10   14

Output: 20 8 4 10 14 25 22

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes the root node as input and returns an array containing the boundary values in anti-clockwise.



Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).



Constraints:
1 = Number of nodes = 105
1 = Data of a node = 105
*/
class BoundaryTraversal
{
    ArrayList<Integer> res = new ArrayList<>();
    void leftBoundary(Node node)
    {
        if(node==null)
            return;

        //left subtree given priority
        if(node.left!=null)
        {
            //store the result then recur for further left subtree
            res.add(node.left);
            leftBoundary(node.left);
        }
        //if left sub-tree doesn't exist then right sub-tree is part of the left boundary
        else if(node.right!=null)
        {
            res.add(node.right);
            leftBoundary(node.right);
        }
    }
    void leafNodes(Node node)
    {
        if(node==null)
            return;

        //recur for left tree
        leafNodes(node.left);
        //if encountered a leaf node, add to the answer
        if(node.left==null && node.right==null)
            res.add(node);
        //recur for right tree
        leafNodes(node.right);
    }
    void rightBoundary(Node node)
    {
        if(node==null)
            return ;

        if(node.right!=null)
        {
            //reach the end of right sub-tree first then add to result,
            //since we need to print in reverse right boundary
            rightBoundary(node.right);
            res.add(node.right);
        }
        else if(node.left!=null)
        {
            rightBoundar(node.left);
            res.add(node.left);
        }
    }

	ArrayList <Integer> printBoundary(Node node)
	{
	    if(node==null)
	        return res;//which is empty rn

	    //left nodes first
	    leftBoundary(node.left);
	    //then leaf nodes
	    leafNodes(node.left);
	    leafNodes(node.right);
	    //then right boundary(reverse)
	    rightBoundary(node.right);

	    return res;

	}
}
