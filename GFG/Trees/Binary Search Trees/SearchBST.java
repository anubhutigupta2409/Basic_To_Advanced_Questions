/*
Binary Search Tree is a tree having 0/1/2 children. All the values which are part of left sub-tree are less than the root, and to
the right are equal or greater than the root node.
*/

public class SearchBST

{
	public Node search(Node root, int key)
	{
		if(root.data == key || root==null)
			return root;

		if(key<root.data)
			return search(root.left,key);

		else
			return search(root.right,key);
	}
}