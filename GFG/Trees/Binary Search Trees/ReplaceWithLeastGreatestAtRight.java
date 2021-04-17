/*
Replace every element with the least greater element on its right
*/

public class ReplaceWithLeastGreatestAtRight
{
	Node findSmallest(Node root)
	{
		if(root==null || root.left==null)
			return root;

		return findSmallest(node.left);
	}
	void replace(Node root)
	{
		if(root==null || root.right==null)
			return;

		root.data=findSmallest(root.right).data;

		if(root.left!=null)
			replace(root.left);

		replace(root.right);
	}
}