/*
Inorder Tree Traversal without recursion and without stack!
Difficulty Level : Hard


Using Morris Traversal, we can traverse the tree without using stack and recursion. The idea of Morris Traversal is based on
Threaded Binary Tree. In this traversal, we first create links to Inorder successor and print the data using these links, and
finally revert the changes to restore original tree.

1. Initialize current as root
2. While current is not NULL
   If the current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Find rightmost node in current left subtree OR
              node whose right child == current.
         If we found right child == current
             a) Update the right child as NULL of that node whose right child is current
             b) Print current’s data
             c) Go to the right, i.e. current = curent->right
         Else
             a) Make current as the right child of that rightmost
                node we found; and
             b) Go to this left child, i.e., current = current->left
Although the tree is modified through the traversal, it is reverted back to its original shape after the completion. Unlike
Stack based traversal, no extra space is required for this traversal.


*/
public class MorrisTravel
{
	void morrisTravel(Node root)
	{
		if(root==null)
			return;

		Node curr, pre;

		curr=root;

		while(curr!=null)
		{
			if(curr.left==null)
			{
				System.out.println(curr.data);
				curr=curr.right;
			}
			//linking to the iop, that is largest node in left sub-tree, that is the right-most node in the left sub-tree
			else
			{
				pre=curr.left;

				while(pre.right!=null && pre.right!=curr)
					pre=pre.right;

				//make current as the right child of it's predecessor
				if(pre.right!=null)
				{
					pre.right = curr;
					curr=curr.left;
				}

				//revert the changes
				else
				{
					pre.right=null;
					System.out.println(curr.data);
					curr=curr.right;
				}
			}
		}
	}
}