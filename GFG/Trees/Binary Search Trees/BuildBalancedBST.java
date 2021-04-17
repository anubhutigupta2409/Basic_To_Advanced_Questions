/*
Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.

Examples :

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30


Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4

Input:
          4
        /   \
       3     5
      /       \
     2         6
    /           \
   1             7
Output:
       4
    /    \
   2      6
 /  \    /  \
1    3  5    7
*/

import java.util.*;

public class BuildBalancedBST
{
	void storeBST(Node root, Vectot<Node> nodes)
	{
		if(root==null)
			return ;
		if(root.left!=null)
			storeBST(root.left,nodes);

		nodes.add(root.data);

		if(root.right!=null)
			storeBST(root.right,nodes)

	}
	Node buildTreeHelper(Vector<Node> nodes, int start, int end)
	{
		if(start>end)
			return null;

		int mid = (start+end)/2;
		Node node = new Node(nodes.get(mid));

		node.left=buildTReeHelper(nodes,start,mid-1);
		node.right=buildTReeHelper(nodes,mid+1,end);

		return node;

	}
	Node buildTree(Node root)
	{
		//storing the nodes of the given BST in sorted manner
		Vector<Node> nodes = new Vector<>();
		storeBST(root,nodes);

		//construct tree
		int n= nodes.size();
		return  buildTreeHelper(nodes,0,n-1);
	}
}